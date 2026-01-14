package com.curdu.cafeflow.c_models.repositoris

import android.content.Context
import androidx.lifecycle.LiveData
import com.curdu.cafeflow.c_models.bbdd.DatabaseConnection
import com.curdu.cafeflow.c_models.entitats.Beguda
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class BegudesRepositori {

    companion object {
        var repositori_database: DatabaseConnection? = null

        var begudes: LiveData<List<Beguda>>? = null

        fun inicialitzarBD(context: Context): DatabaseConnection {
            return DatabaseConnection.getDatabase(context)
        }

        fun obtenirBegudes(context: Context): LiveData<List<Beguda>>? {
            repositori_database = inicialitzarBD(context)

            CoroutineScope(IO).launch {
                begudes = repositori_database!!.begudaDao().obtenirBegudes()

            }
            return begudes
        }
    }
}