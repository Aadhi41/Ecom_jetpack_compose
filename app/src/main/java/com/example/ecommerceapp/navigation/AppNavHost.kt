package com.example.ecommerceapp.navigation

import BottomNavigationBar
import android.provider.ContactsContract.Profile
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerceapp.model.Product
import com.example.ecommerceapp.ui.favourites.FavouritesScreen
import com.example.ecommerceapp.ui.flashsale.productscreen.ProductDetailScreen
import com.example.ecommerceapp.ui.home.HomeScreen
import com.example.ecommerceapp.ui.profile.ProfileScreen
import com.google.gson.Gson

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

            composable("profile_screen") {
                ProfileScreen()
            }

            composable("favourites_screen") {
                FavouritesScreen()
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
}



