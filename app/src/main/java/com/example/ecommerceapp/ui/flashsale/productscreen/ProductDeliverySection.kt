package com.example.ecommerceapp.ui.flashsale.productscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.ecommerceapp.model.Product

@Composable
fun ProductDeliverySection(product: Product) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Delivery on ${product.deliveryDate}",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
    }
}
