package com.curdu.cafeflow.c_models.entitats

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beguda")
data class Beguda(
    @ColumnInfo(name = "capacitat")
    var capacitat: Int,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    override var id: Long,

    @ColumnInfo(name = "nom")
    override var nom: String,

    @ColumnInfo(name = "preu")
    override var preu: Double,
    @ColumnInfo(name = "img_url")
    override var imgUrl: String
) : Producte(id, preu, nom, imgUrl)