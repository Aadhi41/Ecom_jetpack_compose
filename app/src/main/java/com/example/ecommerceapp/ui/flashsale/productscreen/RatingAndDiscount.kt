package com.example.ecommerceapp.ui.flashsale.productscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecommerceapp.R
import com.example.ecommerceapp.model.Product

@Composable
fun RatingAndDiscount(product: Product) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "⭐ ${product.avgReview}",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFFEFE38F))
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "${product.numReviews} reviews",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.discount),
                contentDescription = "Discount",
                tint = Color.Green,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "${product.discountPercentage}%",
                style = MaterialTheme.typography.bodySmall.copy(color = Color.Green)
            )
        }
    }
}