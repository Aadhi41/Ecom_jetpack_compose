package com.example.ecommerceapp.navigation

import BottomNavigationBar
import FavoritesViewModel
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecommerceapp.ui.favourites.FavoritesScreen
import com.example.ecommerceapp.ui.flashsale.productscreen.ProductDetailScreen
import com.example.ecommerceapp.ui.home.HomeScreen
import com.example.ecommerceapp.ui.profile.ProfileScreen
import com.example.ecommerceapp.ui.flashsale.flashscreen.FlashSaleScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home_screen",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home_screen") {
                HomeScreen(navController = navController)
            }

            composable("flash_sale_screen") {
                FlashSaleScreen(navController = navController)
            }

            composable("profile_screen") {
                ProfileScreen()
            }
            composable("favourites_screen") {
                val favoritesViewModel: FavoritesViewModel = viewModel()
                FavoritesScreen(favoritesViewModel = favoritesViewModel, navController = navController)
            }


            composable("productDetail/{productId}") { backStackEntry ->
                val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
                if (productId != null) {
                    ProductDetailScreen(
                        productId = productId,
                        navController = navController,
                        favoritesViewModel = viewModel()
                    )
                }
            }
        }
    }
}
