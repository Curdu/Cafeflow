package com.curdu.cafeflow.b_viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.curdu.cafeflow.c_models.entitats.Postre
import com.curdu.cafeflow.c_models.repositoris.PostresRepositori

class PostresVM : ViewModel(){

    private var _llistat_postres: LiveData<List<Postre>>? = null
    val llistat_postres: LiveData<List<Postre>>?
        get()=_llistat_postres


    fun llistarPostres(context: Context){
        _llistat_postres = PostresRepositori.obtenirPostres(context)
    }
}