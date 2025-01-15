package com.example.ecommerceapp

import android.os.Bundle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerceapp.model.Product
import com.example.ecommerceapp.ui.category.CategoriesScreen
import com.example.ecommerceapp.ui.delivery.DeliveryScreen
import com.example.ecommerceapp.ui.flashsale.flashscreen.FlashSaleScreen
import com.example.ecommerceapp.ui.flashsale.productscreen.ProductDetailScreen
import com.example.ecommerceapp.utils.CategoryViewModel
import com.google.gson.Gson


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
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
                        onBackClick = { navController.popBackStack() } // Handle back navigation
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    val categoryViewModel: CategoryViewModel = viewModel() // ✅ Provide ViewModel instance

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        DeliveryScreen()

        Spacer(modifier = Modifier.height(16.dp))

        CategoriesScreen(viewModel = categoryViewModel) // ✅ Pass ViewModel

        Spacer(modifier = Modifier.height(16.dp))

        FlashSaleScreen(navController = navController)
    }
}
