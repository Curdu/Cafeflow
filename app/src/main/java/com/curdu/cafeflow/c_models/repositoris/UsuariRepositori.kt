package com.curdu.cafeflow.c_models.repositoris

import android.content.Context
import com.curdu.cafeflow.c_models.entitats.Usuari
import com.curdu.cafeflow.c_models.firebase.UserAuth

class UsuariRepositori {
    companion object{
        private val userAuth = UserAuth()
        suspend fun afegirUsuari(context: Context, usuari: Usuari): Boolean{
            return userAuth.afegirUsuari(context, usuari)
        }

        suspend fun iniciarSessio(context: Context, email: String, contrasenya: String) : Usuari? {

            return userAuth.iniciarSessio(email,contrasenya)

        }

    }


}
