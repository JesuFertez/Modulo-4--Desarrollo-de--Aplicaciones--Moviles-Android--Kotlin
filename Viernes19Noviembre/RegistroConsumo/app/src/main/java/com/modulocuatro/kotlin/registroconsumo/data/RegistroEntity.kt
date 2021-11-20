package com.modulocuatro.kotlin.registroconsumo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity (tableName = "registro")
data class RegistroEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int=0,

    @ColumnInfo(name="nombreItem")
    @NotNull
   var nombreItem:String,

    @ColumnInfo(name="precioUnidad")
    @NotNull
    var precioUnidad: Int,

    @ColumnInfo(name="cantidad")
    @NotNull
    var cantidad:Int
        ){

}

