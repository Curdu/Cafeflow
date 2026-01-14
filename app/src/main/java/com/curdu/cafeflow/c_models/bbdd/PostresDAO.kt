package com.curdu.cafeflow.c_models.bbdd

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.curdu.cafeflow.c_models.entitats.Postre


@Dao
interface PostresDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun afegirPostre(postre: Postre)

    @Query("SELECT * FROM postre ORDER BY nom")
    fun obtenirPostres(): LiveData<List<Postre>>

    @Query("SELECT * from postre WHERE postre.id = :idPostre")
    fun obtenirPerId(idPostre: Int): LiveData<Postre>

    @Update
    fun actualitzarPostre(postre: Postre)

    @Delete
    fun eliminarPostre(postre: Postre)
}