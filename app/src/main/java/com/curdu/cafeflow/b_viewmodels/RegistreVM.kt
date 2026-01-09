package com.curdu.cafeflow.b_viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.curdu.cafeflow.c_models.entitats.Usuari
import com.curdu.cafeflow.c_models.repositoris.UsuariRepositori

class RegistreVM : ViewModel() {


    fun registrarUsuari(
        context: Context,
        nom: String,
        email: String,
        contrasenya: String
    ): Boolean {
        try {
            isValidUsuari(nom, email, contrasenya)
            val usuari = Usuari(nom, contrasenya, email)
            UsuariRepositori.afegirUsuari(context, usuari)
        } catch (e: RuntimeException) {
            throw e
        }
        return true
    }

    private fun isValidUsuari(nom: String, email: String, contrasenya: String) {

        if (nom == "") {
            throw RuntimeException("El nom d'usuari no pot estar buit")
        } else if (email == "") {
            throw RuntimeException("L'email no pot estar buit")
        } else if (contrasenya == "") {
            throw RuntimeException("La contrasenya no pot estar buida")
        }
    }

}