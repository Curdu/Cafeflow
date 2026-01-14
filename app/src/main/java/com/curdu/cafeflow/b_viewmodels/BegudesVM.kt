package com.curdu.cafeflow.b_viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.curdu.cafeflow.c_models.entitats.Beguda
import com.curdu.cafeflow.c_models.repositoris.BegudesRepositori

class BegudesVM : ViewModel(){

    private var _llistat_begudes: LiveData<List<Beguda>>? = null
    val llistat_begudes: LiveData<List<Beguda>>?
        get()=_llistat_begudes


    fun llistarBegudes(context: Context){
        _llistat_begudes = BegudesRepositori.obtenirBegudes(context)
    }

}