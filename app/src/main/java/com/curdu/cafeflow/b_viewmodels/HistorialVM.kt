package com.curdu.cafeflow.b_viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curdu.cafeflow.c_models.entitats.Comanda
import com.curdu.cafeflow.c_models.repositoris.HistorialRepositori

class HistorialVM : ViewModel() {



    val historial : LiveData<List<Comanda>> get() = _historial
    private var _historial : MutableLiveData<List<Comanda>> = MutableLiveData(emptyList())
    suspend fun refrescarHistorial(uid: String) {
        _historial.postValue(HistorialRepositori.getHistorial(uid))
    }
}