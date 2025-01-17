package com.example.ecommerceapp.ui.favourites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ecommerceapp.model.Product

@Composable
fun FavouritesScreen(favouritesViewModel: FavouritesViewModel = viewModel()) {
    val favouriteProducts by favouritesViewModel.favouriteProducts.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "Favourites",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (favouriteProducts.isEmpty()) {
            Text("No favourites added", color = Color.Gray, modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            LazyColumn {
                items(favouriteProducts) { product ->
                    ProductItem(product = product)
                }
            }
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = product.name, style = MaterialTheme.typography.bodyLarge)
    }
}
