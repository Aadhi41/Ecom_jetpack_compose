package com.example.ecommerceapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.ecommerceapp.ui.category.CategoriesScreen
import com.example.ecommerceapp.ui.delivery.DeliveryScreen
import com.example.ecommerceapp.ui.flashsale.flashscreen.FlashSaleScreen
import com.example.ecommerceapp.utils.CategoryViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
    val categoryViewModel: CategoryViewModel = viewModel()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        DeliveryScreen()

        Spacer(modifier = Modifier.height(16.dp))

        CategoriesScreen(viewModel = categoryViewModel)

        Spacer(modifier = Modifier.height(16.dp))

        FlashSaleScreen(navController = navController)
    }
}
