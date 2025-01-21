package com.example.ecommerceapp.dao

import androidx.room.*
import com.example.ecommerceapp.dao.FavoriteProductEntity

@Dao
interface FavoriteProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(product: FavoriteProductEntity)

    @Delete
    suspend fun removeFavorite(product: FavoriteProductEntity)

    @Query("SELECT * FROM favorite_products")
    suspend fun getAllFavorites(): List<FavoriteProductEntity>
}


