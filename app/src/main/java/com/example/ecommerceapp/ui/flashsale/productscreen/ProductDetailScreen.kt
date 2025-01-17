package com.example.ecommerceapp.ui.flashsale.productscreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ecommerceapp.R
import com.example.ecommerceapp.model.Product
import com.example.ecommerceapp.ui.favourites.FavouritesViewModel
import com.example.ecommerceapp.ui.flashsale.flashscreen.PriceDisplay
import com.example.ecommerceapp.ui.theme.yellowColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    product: Product,
    onBackClick: () -> Unit,
    favouritesViewModel: FavouritesViewModel = viewModel()
) {
    val context = LocalContext.current
    var isFavourite by remember { mutableStateOf(favouritesViewModel.isFavourite(product)) }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.Black
                            )
                        }
                        Text(
                            text = "Product Details",
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.Black
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        if (isFavourite) {
                            favouritesViewModel.removeFromFavourites(product)
                            Toast.makeText(context, "Removed from favourites", Toast.LENGTH_SHORT).show()
                        } else {
                            favouritesViewModel.addToFavourites(product)
                            Toast.makeText(context, "Added to favourites", Toast.LENGTH_SHORT).show()
                        }
                        isFavourite = !isFavourite
                    }) {
                        Icon(
                            imageVector = if (isFavourite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Add to favourites",
                            tint = if (isFavourite) Color.Red else Color.Gray
                        )
                    }
                },
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
                            color = yellowColor,
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
                        contentScale = ContentScale.Fit
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

                RatingAndDiscount(product)

                Spacer(modifier = Modifier.height(8.dp))

                PriceDisplay(
                    discountedPrice = product.discountedPrice,
                    originalPrice = product.originalPrice
                )

                Spacer(modifier = Modifier.height(8.dp))

                ProductDetails(product.details)

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
