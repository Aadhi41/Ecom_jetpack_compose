package com.example.ecommerceapp.ui.favourites

import androidx.lifecycle.ViewModel
import com.example.ecommerceapp.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FavouritesViewModel : ViewModel() {
    private val _favouriteProducts = MutableStateFlow<List<Product>>(emptyList())
    val favouriteProducts: StateFlow<List<Product>> = _favouriteProducts

    fun addToFavourites(product: Product) {
        if (!_favouriteProducts.value.contains(product)) {
            _favouriteProducts.value += product
        }
    }

    fun removeFromFavourites(product: Product) {
        _favouriteProducts.value -= product
    }

    fun isFavourite(product: Product): Boolean {
        return _favouriteProducts.value.contains(product)
    }
}

