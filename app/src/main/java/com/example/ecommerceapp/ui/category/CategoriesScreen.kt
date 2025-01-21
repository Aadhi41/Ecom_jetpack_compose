package com.example.ecommerceapp.ui.category

import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.ecommerceapp.utils.CategoryViewModel

@Composable
fun CategoriesScreen(viewModel: CategoryViewModel) {
    CategoriesSection(viewModel = viewModel)
}

