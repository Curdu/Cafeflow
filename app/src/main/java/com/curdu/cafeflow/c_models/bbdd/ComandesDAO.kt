package com.curdu.cafeflow.c_models.bbdd

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.curdu.cafeflow.c_models.entitats.Comanda

@Dao
interface ComandesDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun afegirComanda(comanda: Comanda)

    @Query("SELECT * FROM comanda ORDER BY id DESC")
    fun obtenirComandes(): LiveData<List<Comanda>>

    @Query("SELECT * FROM comanda WHERE usuari_comprador = :usuari")
    fun obtenirPerUsuari(usuari: String): LiveData<List<Comanda>>

    @Update
    fun actualitzarComanda(comanda: Comanda)

    @Delete
    fun eliminarComanda(comanda: Comanda)
}