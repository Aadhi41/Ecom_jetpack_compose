package com.example.ecommerceapp.utils


import com.example.ecommerceapp.R
import com.example.ecommerceapp.model.Category

object SampleData {
    val categoryList = listOf(
        Category("Phones", R.drawable.phone),
        Category("Consoles", R.drawable.console),
        Category("Laptops", R.drawable.laptop),
        Category("Cameras", R.drawable.camera),
        Category("Wearables", R.drawable.wearable),
        Category("Tablets", R.drawable.tablet),
        Category("Accessories", R.drawable.acess),
        Category("Smart Home", R.drawable.smart),
        Category("Gaming", R.drawable.gaming)
    )
}
