package com.curdu.cafeflow.b_viewmodels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curdu.cafeflow.c_models.entitats.Usuari
import com.curdu.cafeflow.c_models.repositoris.UsuariRepositori
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginVM : ViewModel(){

    val usuari : LiveData<Usuari?>
        get() = _usuari

    private var _usuari : MutableLiveData<Usuari?> = MutableLiveData(null)
    fun iniciarSessio(context: Context, email: String, contrasenya: String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val user = UsuariRepositori.iniciarSessio(context, email, contrasenya)
                _usuari.postValue(user)
            }catch (e: Exception) {

            }

        }
    }

}