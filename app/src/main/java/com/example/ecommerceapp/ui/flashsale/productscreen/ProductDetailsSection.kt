package com.example.ecommerceapp.ui.flashsale.productscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.ecommerceapp.model.Product

@Composable
fun ProductDetailsSection(product: Product) {
    Column {
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "New Arrival",
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.Green),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = product.details,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}
