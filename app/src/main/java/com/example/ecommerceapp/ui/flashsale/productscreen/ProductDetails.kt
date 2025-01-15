package com.example.ecommerceapp.ui.flashsale.productscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun ProductDetails(details: String) {
    var expanded by remember { mutableStateOf(false) }
    Column {

        Text(
            text = details,
            maxLines = if (expanded) Int.MAX_VALUE else 3,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodyMedium
        )
        TextButton(onClick = { expanded = !expanded }) {
            Text(text = if (expanded) "Show less" else "Show more")
        }
    }
}
