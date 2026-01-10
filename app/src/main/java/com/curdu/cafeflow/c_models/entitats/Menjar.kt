package com.curdu.cafeflow.c_models.entitats

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "menjar")
data class Menjar(
    @ColumnInfo(name = "es_vegetaria")
    var esVegetaria: Boolean = false,

    @ColumnInfo(name = "ingredients")
    var ingredients: String = "",

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    override var id: Long = 0,

    @ColumnInfo(name = "nom")
    override var nom: String = "",

    @ColumnInfo(name = "preu")
    override var preu: Double = 0.0
) : Producte(id, preu, nom)