package com.curdu.cafeflow.c_models.repositoris

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.curdu.cafeflow.c_models.entitats.Comanda
import com.curdu.cafeflow.c_models.firebase.HistorialFirebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistorialRepositori {

    companion object {
        private val historialFirebase = HistorialFirebase()

        suspend fun afegirComandaHistorial(comanda: Comanda) {
            historialFirebase.afegirNovaComanda(comanda)
        }

        suspend fun getHistorial(uid: String) : List<Comanda> {
            return historialFirebase.getHistorial(uid)
        }
    }
}