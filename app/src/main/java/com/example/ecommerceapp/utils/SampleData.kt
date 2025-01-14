package com.example.ecommerceapp.utils



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.R
import com.example.ecommerceapp.model.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {
    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    init {
        loadCategories()
    }

    private fun loadCategories() {
        viewModelScope.launch {
            _categories.value = listOf(
                Category("Phones", R.drawable.phone),
                Category("Consoles", R.drawable.console),
                Category("Laptops", R.drawable.laptop),
                Category("Cameras", R.drawable.camera),
                Category("Wearables", R.drawable.wearable),
                Category("Tablets", R.drawable.tablet),
                Category("Accessories", R.drawable.acess),
                Category("Smart Home", R.drawable.smart),
                Category("Gaming", R.drawable.gaming)
            )
        }
    }
}