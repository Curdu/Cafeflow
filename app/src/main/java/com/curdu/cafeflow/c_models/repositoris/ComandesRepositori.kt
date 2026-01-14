package com.curdu.cafeflow.c_models.repositoris

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.curdu.cafeflow.c_models.bbdd.DatabaseConnection
import com.curdu.cafeflow.c_models.entitats.Comanda
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ComandesRepositori {
    companion object {
        var repositori_database: DatabaseConnection? = null

        var comandes: LiveData<List<Comanda>>? = null

        fun inicialitzarBD(context: Context): DatabaseConnection {
            return DatabaseConnection.getDatabase(context)
        }

        fun obtenirComandes(context: Context): LiveData<List<Comanda>>? {
            repositori_database = inicialitzarBD(context)

            CoroutineScope(IO).launch {
                comandes = repositori_database!!.comandaDao().obtenirComandes()
            }
            return comandes
        }

        fun afegirComanda(context: Context, comanda: Comanda) {
            repositori_database = inicialitzarBD(context)
            Log.i("Comandes", comanda.toString())
            CoroutineScope(IO).launch {
                repositori_database!!.comandaDao().afegirComanda(comanda)
            }
        }
    }
}