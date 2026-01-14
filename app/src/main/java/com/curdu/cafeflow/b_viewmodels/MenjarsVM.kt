package com.curdu.cafeflow.b_viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.curdu.cafeflow.c_models.entitats.Menjar
import com.curdu.cafeflow.c_models.repositoris.MenjarsRepositori

class MenjarsVM : ViewModel() {

    private var _llistat_menjars: LiveData<List<Menjar>>? = null
    val llistat_menjars: LiveData<List<Menjar>>?
        get() = _llistat_menjars


    fun llistarMenjars(context: Context) {
        _llistat_menjars = MenjarsRepositori.obtenirMenjars(context)
    }
}