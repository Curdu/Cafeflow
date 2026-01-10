package com.curdu.cafeflow.c_models.entitats

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

open class Producte(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    open var id: Long,
    @ColumnInfo(name = "preu")
    open var preu: Double,
    @ColumnInfo(name = "nom")
    open var nom: String
)