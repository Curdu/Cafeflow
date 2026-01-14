package com.curdu.cafeflow.c_models.entitats

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comanda")
data class Comanda (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long,

    @ColumnInfo(name = "preu_total")
    var preuTotal : Double,

    @ColumnInfo(name = "usuari_comprador")
    var usuariComprador: String
)