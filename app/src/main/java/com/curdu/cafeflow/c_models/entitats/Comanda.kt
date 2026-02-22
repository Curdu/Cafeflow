package com.curdu.cafeflow.c_models.entitats

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comanda")
data class Comanda (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0,

    @ColumnInfo(name = "preu_total")
    var preuTotal : Double = 0.0,

    @ColumnInfo(name = "usuari_comprador")
    var usuariComprador: String = ""
)