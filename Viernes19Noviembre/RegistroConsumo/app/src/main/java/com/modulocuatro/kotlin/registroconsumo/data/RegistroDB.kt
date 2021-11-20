package com.modulocuatro.kotlin.registroconsumo.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [RegistroEntity::class],
    version = 1,
    exportSchema = false)

abstract class RegistroDB :RoomDatabase (){
    abstract val  registroDao : RegistroDao

    companion object{
        const val DATABASE_NAME = "registros"
    }
}