package com.example.ecommerceapp.model
data class Product(
    val id: Int, // Ensure this is an Int
    val name: String,
    val imageRes: Int,
    val originalPrice: Double,
    val discountedPrice: Double,
    val discountPercentage: Double,
    val details: String,
    val avgReview: Float,
    val numReviews: Int,
    val deliveryDate: String
)
