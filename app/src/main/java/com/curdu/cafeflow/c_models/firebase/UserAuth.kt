package com.curdu.cafeflow.c_models.firebase

import android.content.Context
import android.util.Log
import com.curdu.cafeflow.c_models.entitats.Usuari
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class UserAuth {

    private val auth = Firebase.auth
    private val firestore = Firebase.firestore

    suspend fun afegirUsuari(context: Context ,usuari: Usuari): Boolean {
        try{
            val id = auth.createUserWithEmailAndPassword(usuari.email, usuari.contrasenya).await().user?.uid
            if(id != null){
                usuari.contrasenya = ""
                firestore.collection("usuaris").document(id).set(usuari)
                return true
            }
            return false
        }catch (e: FirebaseAuthUserCollisionException){
            throw Exception("Un usuari amb aquest correu ja existeix")
        }
    }

    suspend fun iniciarSessio(email: String, passwd: String): Usuari? {
        try{
            val firebaseUser : FirebaseUser? = auth.signInWithEmailAndPassword(email, passwd).await().user
            return if(firebaseUser != null){
                Log.i("Login", "Usuari iniciat sessió")
                val data = firestore.collection("usuaris").document(firebaseUser.uid).get().await()
                Usuari(data["nom"].toString(),"", firebaseUser.email!!)
            }else {
                null
            }
        }catch (e: FirebaseAuthInvalidCredentialsException){
            throw Exception("L'usuari o la contrasenya son incorrectes")
        }catch (e: FirebaseAuthInvalidUserException){
            throw Exception("L'usuari o la contrasenya son incorrectes")
        }

    }
}