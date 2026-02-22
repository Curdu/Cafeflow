package com.curdu.cafeflow.c_models.firebase

import com.curdu.cafeflow.c_models.entitats.Comanda
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class HistorialFirebase {

    val firestore = Firebase.firestore
    val auth = Firebase.auth

    suspend fun afegirNovaComanda(comanda: Comanda) {
        firestore
            .collection("usuaris")
            .document(auth.uid.toString())
            .collection("comanda")
            .document()
            .set(comanda)
            .await()
    }

    suspend fun getHistorial(uuid: String): List<Comanda> {
        val coleccio = firestore
            .collection("usuaris")
            .document(uuid)
            .collection("comanda")
            .get()
            .await()

        return if (coleccio.isEmpty){
            emptyList()
        } else {
            coleccio.toObjects(Comanda::class.java)
        }
    }
}