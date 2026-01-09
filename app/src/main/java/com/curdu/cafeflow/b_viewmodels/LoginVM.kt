package com.curdu.cafeflow.b_viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.curdu.cafeflow.c_models.entitats.Usuari
import com.curdu.cafeflow.c_models.repositoris.UsuariRepositori

class LoginVM : ViewModel(){


    fun iniciarSessio(context: Context, nom: String, contrasenya: String): Usuari{
        try {
            val usuari : Usuari = UsuariRepositori.getUsuari(context,nom)
            if(usuari.contrasenya == contrasenya){
                return usuari
            }else {
                throw RuntimeException("Credencials incorrectes")
            }
        }catch (e : RuntimeException){
            throw e
        }
    }

}