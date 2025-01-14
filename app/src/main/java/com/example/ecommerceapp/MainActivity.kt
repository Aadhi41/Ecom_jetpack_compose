package com.example.ecommerceapp

import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerceapp.model.Product
import com.example.ecommerceapp.ui.category.CategoriesScreen
import com.example.ecommerceapp.ui.delivery.DeliveryScreen
import com.example.ecommerceapp.ui.flashsale.FlashSaleScreen
import com.example.ecommerceapp.ui.flashsale.ProductCard
import com.example.ecommerceapp.ui.flashsale.ProductDetailScreen
import com.example.ecommerceapp.ui.theme.EcommerceappTheme
import com.example.ecommerceapp.utils.CategoryViewModel
import com.example.ecommerceapp.utils.Products
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
                    ProductDetailScreen(product = product)
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

