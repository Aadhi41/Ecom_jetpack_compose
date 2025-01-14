package com.example.ecommerceapp.model


import androidx.annotation.DrawableRes

data class Category(
    val name: String,
    @DrawableRes val iconRes: Int
)