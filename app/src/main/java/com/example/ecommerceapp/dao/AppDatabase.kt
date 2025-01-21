package com.example.ecommerceapp.dao


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ecommerceapp.dao.FavoriteProductEntity

@Database(entities = [FavoriteProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteProductDao(): FavoriteProductDao
}


