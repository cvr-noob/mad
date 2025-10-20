package com.example.inventoryapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class ItemDB : RoomDatabase() {
    abstract fun dao(): ItemDao

    companion object {
        private var INSTANCE: ItemDB? = null

        fun getInstance(context: Context): ItemDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDB::class.java,
                    "ItemTable"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}