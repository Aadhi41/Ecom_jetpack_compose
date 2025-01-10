package com.example.ecommerceapp.ui.category

import androidx.compose.runtime.*
import androidx.compose.runtime.Composable

@Composable
fun CategoriesScreen() {
    var showAllCategories by remember { mutableStateOf(false) }

    if (showAllCategories) {
        FullCategoryScreen(onBack = { showAllCategories = false })
    } else {
        CategoriesSection(onSeeAllClick = { showAllCategories = true })
    }
}
