package com.example.inventoryapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ItemDao {
    @Insert suspend fun insert(item: Item)
    @Update suspend fun update(item: Item)
    @Delete suspend fun delete(item: Item)

    @Query("SELECT * FROM Item")
    fun getAll(): LiveData<List<Item>>
}