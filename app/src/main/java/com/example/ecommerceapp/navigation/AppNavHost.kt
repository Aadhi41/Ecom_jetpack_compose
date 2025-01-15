package com.example.ecommerceapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecommerceapp.model.Product
import com.example.ecommerceapp.ui.flashsale.productscreen.ProductDetailScreen
import com.example.ecommerceapp.ui.home.HomeScreen
import com.google.gson.Gson

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home_screen"
    ) {
        composable("home_screen") {
            HomeScreen(navController = navController)
        }
        composable("productDetail/{productJson}") { backStackEntry ->
            val productJson = backStackEntry.arguments?.getString("productJson")
            val product = Gson().fromJson(productJson, Product::class.java)
            ProductDetailScreen(
                product = product,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
