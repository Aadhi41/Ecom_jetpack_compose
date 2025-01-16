package com.example.ecommerceapp.ui.favourites


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FavouritesScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Favourites Page", style = MaterialTheme.typography.headlineMedium)
    }
}