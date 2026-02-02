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
import kotlinx.coroutines.tasks.await

class UserAuth {

    private val auth = Firebase.auth

    suspend fun afegirUsuari(context: Context ,usuari: Usuari): Boolean {
        return try{
            auth.createUserWithEmailAndPassword(usuari.email, usuari.contrasenya).await()
            true
        }catch (e: FirebaseAuthUserCollisionException){
            throw Exception("Un usuari amb aquest correu ja existeix")
        }
    }

    suspend fun iniciarSessio(email: String, passwd: String): Usuari? {
        try{
            val firebaseUser : FirebaseUser? = auth.signInWithEmailAndPassword(email, passwd).await().user
            return if(firebaseUser != null){
                Log.i("Login", "Usuari iniciat sessió")
                Usuari("","", firebaseUser.email!!)
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