package com.curdu.cafeflow.c_models.entitats

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "postre")
data class Postre(
    @ColumnInfo(name = "calories")
    var calories: Int = 0,

    @ColumnInfo(name = "es_casola")
    var esCasola: Boolean = false,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    override var id: Long = 0,

    @ColumnInfo(name = "nom")
    override var nom: String = "",

    @ColumnInfo(name = "preu")
    override var preu: Double = 0.0,
    @ColumnInfo(name = "img_url")
    override var imgUrl: String
) : Producte(id, preu, nom, imgUrl)