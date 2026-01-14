package com.curdu.cafeflow.c_models.bbdd

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.curdu.cafeflow.c_models.entitats.Menjar


@Dao
interface MenjarsDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun afegirMenjar(menjar: Menjar)

    @Query("SELECT * FROM menjar ORDER BY nom")
    fun obtenirMenjars(): LiveData<List<Menjar>>

    @Query("SELECT * from menjar WHERE menjar.id = :idMenjar")
    fun obtenirPerId(idMenjar: Int): LiveData<Menjar>

    @Update
    fun actualitzarMenjar(menjar: Menjar)

    @Delete
    fun eliminarMenjar(menjar: Menjar)
    
    
}