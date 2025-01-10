package com.example.ecommerceapp.model

data class Product(
    val name: String,
    val imageRes: Int,
    val originalPrice: Int,
    val discountedPrice: Int,
    val discountPercentage: Int,
    val details: String,
    val avgReview: Float,
    val numReviews: Int,
    val deliveryDate: String
)