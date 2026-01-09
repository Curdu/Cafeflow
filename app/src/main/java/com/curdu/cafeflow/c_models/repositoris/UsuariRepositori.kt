package com.curdu.cafeflow.c_models.repositoris

import android.content.Context
import androidx.core.content.edit
import com.curdu.cafeflow.R
import com.curdu.cafeflow.c_models.entitats.Usuari

 class UsuariRepositori {
    companion object{
        fun afegirUsuari(context: Context, usuari: Usuari){
            val sharedPreferences = context.getSharedPreferences(context.getString(R.string.SP_key),Context.MODE_PRIVATE)

            if(existUsuari(context, usuari.nom)){
                throw RuntimeException("L'usuari amb el nom: '${usuari.nom}' ja existeix")
            }else {
                sharedPreferences.edit {
                    this.putString( usuari.nom, usuari.contrasenya)
                    this.putString( "email_${usuari.nom}", usuari.email)
                    commit()
                }
            }
        }

        fun getUsuari(context: Context, nom: String) : Usuari{
            val sharedPreferences = context.getSharedPreferences(context.getString(R.string.SP_key),Context.MODE_PRIVATE)

            val contrasenya : String? = sharedPreferences.getString(nom, "")
            val email : String? = sharedPreferences.getString("email_$nom", "")

            if(contrasenya.equals("") || contrasenya == null || email.equals("") || email == null) {
                throw RuntimeException(context.getString(R.string.error_usuari_no_existent))
            }else{
                return Usuari(nom, contrasenya, email)
            }
        }

        fun existUsuari(context: Context, nom: String): Boolean {
            val sharedPreferences = context.getSharedPreferences(context.getString(R.string.SP_key),Context.MODE_PRIVATE)

            val contrasenya : String? = sharedPreferences.getString(nom, "")
            val email : String? = sharedPreferences.getString("email_$nom", "")

            return !(contrasenya.equals("") || contrasenya == null || email.equals("") || email == null)
        }
    }


}