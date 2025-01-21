import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.ecommerceapp.dao.AppDatabase
import com.example.ecommerceapp.dao.FavoriteProductEntity
import com.example.ecommerceapp.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {

    private val db: AppDatabase = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "ecommerceapp.db"
    ).build()

    private val favoriteProductDao = db.favoriteProductDao()

    // Using MutableStateFlow for reactivity
    private val _favoriteProducts = MutableStateFlow<List<Product>>(emptyList())
    val favoriteProducts: StateFlow<List<Product>> get() = _favoriteProducts

    init {
        // Load favorites in the background
        viewModelScope.launch(Dispatchers.IO) {
            val favorites = favoriteProductDao.getAllFavorites()
            _favoriteProducts.value = favorites.map { entityToProduct(it) }
        }
    }

    // Check if product is in favorites
    fun isFavorite(product: Product): Boolean {
        return _favoriteProducts.value.contains(product)
    }

    // Toggle favorite status (add or remove)
    fun toggleFavorite(product: Product) {
        viewModelScope.launch {
            if (_favoriteProducts.value.contains(product)) {
                // Remove from favorites
                _favoriteProducts.value = _favoriteProducts.value - product
                withContext(Dispatchers.IO) {
                    favoriteProductDao.removeFavorite(productToEntity(product))
                }
            } else {
                // Add to favorites
                _favoriteProducts.value = _favoriteProducts.value + product
                withContext(Dispatchers.IO) {
                    favoriteProductDao.addFavorite(productToEntity(product))
                }
            }
        }
    }

    // Convert Product to FavoriteProductEntity
    private fun productToEntity(product: Product): FavoriteProductEntity {
        return FavoriteProductEntity(
            id = product.id,
            name = product.name,
            imageRes = product.imageRes,
            discountedPrice = product.discountedPrice
        )
    }

    // Convert FavoriteProductEntity to Product
    private fun entityToProduct(entity: FavoriteProductEntity): Product {
        return Product(
            id = entity.id,
            name = entity.name,
            imageRes = entity.imageRes,
            originalPrice = 100.0, // Example static value
            discountedPrice = entity.discountedPrice,
            discountPercentage = 10.0,
            details = "Default details",
            avgReview = 4.5f,
            numReviews = 50,
            deliveryDate = "2023-12-31"
        )
    }

    // Function to remove a product from favorites directly
    fun removeFromFavourites(product: Product) {
        viewModelScope.launch {
            _favoriteProducts.value = _favoriteProducts.value - product
            withContext(Dispatchers.IO) {
                favoriteProductDao.removeFavorite(productToEntity(product))
            }
        }
    }
}
