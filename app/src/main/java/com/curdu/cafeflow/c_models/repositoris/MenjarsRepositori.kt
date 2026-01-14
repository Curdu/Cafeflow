package com.curdu.cafeflow.c_models.repositoris

import android.content.Context
import androidx.lifecycle.LiveData
import com.curdu.cafeflow.c_models.bbdd.DatabaseConnection
import com.curdu.cafeflow.c_models.entitats.Menjar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MenjarsRepositori {
    companion object {
        var repositori_database: DatabaseConnection? = null

        var menjars: LiveData<List<Menjar>>? = null

        fun inicialitzarBD(context: Context): DatabaseConnection {
            return DatabaseConnection.getDatabase(context)
        }

        fun obtenirMenjars(context: Context): LiveData<List<Menjar>>? {
            repositori_database = inicialitzarBD(context)

            CoroutineScope(IO).launch {
                menjars = repositori_database!!.menjarDao().obtenirMenjars()

            }
            return menjars
        }
    }
}