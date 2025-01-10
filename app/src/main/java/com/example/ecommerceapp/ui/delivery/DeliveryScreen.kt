package com.example.ecommerceapp.ui.delivery

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable

@Composable
fun DeliveryScreen() {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        DeliveryAddressHeader()
        Spacer(modifier = Modifier.height(12.dp))
        SearchBar(searchQuery, onSearchQueryChanged = { searchQuery = it })
        Spacer(modifier = Modifier.height(12.dp))
        DeliveryDiscountBox()
    }
}
