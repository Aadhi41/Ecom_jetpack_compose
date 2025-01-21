package com.example.ecommerceapp.ui.flashsale.productscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.ecommerceapp.model.Product

@Composable
fun ProductPricingSection(product: Product) {
    Column {
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "₹${product.discountedPrice}",
            style = MaterialTheme.typography.headlineMedium.copy(color = Color.Black)
        )
        Text(
            text = "₹${product.originalPrice}",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.Gray,
                textDecoration = TextDecoration.LineThrough
            )
        )
    }
}
