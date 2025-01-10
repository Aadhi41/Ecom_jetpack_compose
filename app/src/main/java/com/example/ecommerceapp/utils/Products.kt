package com.example.ecommerceapp.utils

import com.example.ecommerceapp.R
import com.example.ecommerceapp.model.Product

object Products {
    val products = listOf(
        Product(
            name = "Apple iPhone 15 Pro 128GB Natural Titanium",
            imageRes = R.drawable.iphone,
            originalPrice = 73900,
            discountedPrice = 69900,
            discountPercentage = 5,
            details = "Experience the ultimate in performance and design with the new iPhone 15 Pro.",
            avgReview = 4.8f,
            numReviews = 117,
            deliveryDate = "26 January"
        ),
        Product(
            name = "Samsung Galaxy Buds Pro True Wireless Black",
            imageRes = R.drawable.galaxy,
            originalPrice = 8500,
            discountedPrice = 6900,
            discountPercentage = 19,
            details = "Immerse yourself in rich sound with noise cancellation and a comfortable fit.",
            avgReview = 4.5f,
            numReviews = 80,
            deliveryDate = "27 January"
        ),
        Product(
            name = "Sony WH-1000XM5 Wireless Headphones",
            imageRes = R.drawable.sony,
            originalPrice = 29990,
            discountedPrice = 27990,
            discountPercentage = 7,
            details = "Enjoy exceptional sound quality and noise cancellation for uninterrupted listening.",
            avgReview = 4.7f,
            numReviews = 96,
            deliveryDate = "28 January"
        ),
        Product(
            name = "Apple Watch Series 9",
            imageRes = R.drawable.apple,
            originalPrice = 41900,
            discountedPrice = 39900,
            discountPercentage = 5,
            details = "Track your fitness, stay connected, and enjoy seamless integration with your iPhone.",
            avgReview = 4.6f,
            numReviews = 105,
            deliveryDate = "29 January"
        ),
        Product(
            name = "Samsung Galaxy Tab S9",
            imageRes = R.drawable.tab,
            originalPrice = 85000,
            discountedPrice = 79900,
            discountPercentage = 6,
            details = "A powerful tablet with an immersive display and versatile features for productivity.",
            avgReview = 4.4f,
            numReviews = 70,
            deliveryDate = "30 January"
        ),
        Product(
            name = "Logitech MX Master 3S Mouse",
            imageRes = R.drawable.logi,
            originalPrice = 10999,
            discountedPrice = 8999,
            discountPercentage = 18,
            details = "Designed for precision, comfort, and productivity, the MX Master 3S is perfect for professionals.",
            avgReview = 4.9f,
            numReviews = 50,
            deliveryDate = "31 January"
        )
    )
}
