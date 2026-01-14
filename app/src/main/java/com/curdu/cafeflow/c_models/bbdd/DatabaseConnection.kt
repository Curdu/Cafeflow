package com.curdu.cafeflow.c_models.bbdd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.curdu.cafeflow.c_models.entitats.*

@Database(
    entities = [Beguda::class, Postre::class, Menjar::class, Comanda::class],
    version = 3,
    exportSchema = false
)
abstract class DatabaseConnection : RoomDatabase() {

    abstract fun begudaDao(): BegudesDAO
    abstract fun postreDao(): PostresDAO
    abstract fun menjarDao(): MenjarsDAO
    abstract fun comandaDao(): ComandesDAO

    companion object {
        @Volatile
        private var INSTANCE: DatabaseConnection? = null

        fun getDatabase(context: Context): DatabaseConnection {
            val instance = INSTANCE
            if (instance != null) {
                return instance
            }
            synchronized(this) {
                val instanceDB = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseConnection::class.java,
                    "cafeflow_database"
                )
                    .createFromAsset("database/cafeflow.db")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instanceDB
                return instanceDB
            }
        }
    }
}