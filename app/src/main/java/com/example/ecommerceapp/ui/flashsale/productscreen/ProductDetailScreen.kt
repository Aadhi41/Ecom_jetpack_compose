package com.example.ecommerceapp.ui.flashsale.productscreen

import FavoritesViewModel
import Products.products
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ecommerceapp.model.Product

@Composable
fun ProductDetailScreen(
    productId: Int,
    navController: NavController,
    favoritesViewModel: FavoritesViewModel
) {
    // Convert productId to a string for comparison
    val product = products.find { it.id == productId } ?: return


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = product.name, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "\$${product.discountedPrice}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = product.details)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { favoritesViewModel.toggleFavorite(product) }) {
            Text(text = "Add to Favorites")
        }
    }
}
