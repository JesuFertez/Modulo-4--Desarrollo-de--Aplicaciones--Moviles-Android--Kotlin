package com.modulocuatro.kotlin.registroconsumo.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RegistroDao {

    @Insert
    fun insert(registro:RegistroEntity)

    @Query("SELECT * FROM registro")
    fun getAllRegistros():LiveData<List<RegistroEntity>>

    @Insert
    fun inserAll(vararg registro: RegistroEntity)

    @Delete
    fun delete(registro: RegistroEntity)

    @Update
    fun update(registro: RegistroEntity)

    @Query("SELECT * FROM registro WHERE id = :id")
    fun getById(id:Int):RegistroEntity


}

