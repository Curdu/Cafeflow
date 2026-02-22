package com.curdu.cafeflow.b_viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curdu.cafeflow.c_models.entitats.Usuari
import com.curdu.cafeflow.c_models.repositoris.UsuariRepositori
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistreVM : ViewModel() {

    val creat: LiveData<Boolean>
        get() = _creat
    private var _creat: MutableLiveData<Boolean> = MutableLiveData(false)

    fun registrarUsuari(
        context: Context,
        nom: String,
        email: String,
        contrasenya: String
    ) {
        try{
            isValidUsuari(nom, email, contrasenya)
            viewModelScope.launch(Dispatchers.IO) {
                val usuari = Usuari(nom, contrasenya, email)
                try {
                    _creat.postValue(UsuariRepositori.afegirUsuari(context, usuari))

                }catch (e : Exception) {

                }
            }
        }catch (e: RuntimeException) {
            throw e

        }
    }

    private fun isValidUsuari(nom: String, email: String, contrasenya: String) {

        if (nom == "") {
            throw RuntimeException("El nom d'usuari no pot estar buit")
        } else if (email == "") {
            throw RuntimeException("L'email no pot estar buit")
        } else if (contrasenya == "") {
            throw RuntimeException("La contrasenya no pot estar buida")
        } else if (contrasenya.length < 6){
            throw RuntimeException("La contrasenya ha de tenir mínim 6 caracters")
        }
    }

}