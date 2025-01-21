package com.example.ecommerceapp.dao

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "favorite_products")
data class FavoriteProductEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val imageRes: Int,
    val discountedPrice: Double
)
