package com.curdu.cafeflow.c_models.bbdd

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.curdu.cafeflow.c_models.entitats.Beguda

@Dao
interface BegudesDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun afegirBeguda(beguda: Beguda)

    @Query("SELECT * FROM beguda ORDER BY nom")
    fun obtenirBegudes(): LiveData<List<Beguda>>

    @Query("SELECT * from beguda WHERE beguda.id = :idBeguda")
    fun obtenirPerId(idBeguda: Int): LiveData<Beguda>

    @Update
    fun actualitzarBeguda(beguda: Beguda)

    @Delete
    fun eliminarBeguda(beguda: Beguda)

}