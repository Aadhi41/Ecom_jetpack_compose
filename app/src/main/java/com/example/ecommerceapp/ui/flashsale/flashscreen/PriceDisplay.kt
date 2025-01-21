package com.example.ecommerceapp.ui.flashsale.flashscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun PriceDisplay(discountedPrice: Int, originalPrice: Double) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "₹$discountedPrice",
            style = MaterialTheme.typography.bodySmall.copy(color = Color.Green)
        )
        Text(
            text = "₹$originalPrice",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.Gray,
                textDecoration = TextDecoration.LineThrough
            )
        )
    }
}