package com.example.ecommerceapp.ui.flashsale.productscreen

import FavoritesViewModel
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ecommerceapp.model.Product

@Composable
fun AddToFavoritesButton(favoritesViewModel: FavoritesViewModel, product: Product) {
    Button(
        onClick = { favoritesViewModel.toggleFavorite(product) },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEFE38F)),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Text(text = "Add to Favorites", color = Color.Black)
    }
}
