package com.example.ecommerceapp.ui.flashsale

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import com.example.ecommerceapp.R
import com.example.ecommerceapp.model.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(product: Product) {
    val context = LocalContext.current
    val yellowColor = Color(0xFFFFF176)

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = { Text("Product Details", style = MaterialTheme.typography.headlineMedium) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = yellowColor,
                    titleContentColor = Color.Black
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .border(
                            width = 4.dp,
                            color = yellowColor, // Light Yellow Border
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(product.imageRes),
                        contentDescription = product.name,
                        modifier = Modifier
                            .fillMaxSize()
                            .aspectRatio(1.5f)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = product.name,
                    style = MaterialTheme.typography.headlineLarge,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "⭐ ${product.avgReview}",
                            style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFFEFE38F)) // Gold for stars
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

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        Toast.makeText(context, "Added to cart", Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEFE38F)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(text = "Add to cart", color = Color.Black)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Delivery on ${product.deliveryDate}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    )
}
