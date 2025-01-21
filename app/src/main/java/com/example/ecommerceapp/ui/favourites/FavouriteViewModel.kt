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

    private val _favoriteProducts = MutableStateFlow<List<Product>>(emptyList())
    val favoriteProducts: StateFlow<List<Product>> get() = _favoriteProducts

    init {

        viewModelScope.launch(Dispatchers.IO) {
            val favorites = favoriteProductDao.getAllFavorites()
            _favoriteProducts.value = favorites.map { entityToProduct(it) }
        }
    }

    fun isFavorite(product: Product): Boolean {
        return _favoriteProducts.value.contains(product)
    }

    fun toggleFavorite(product: Product) {
        viewModelScope.launch {
            if (_favoriteProducts.value.contains(product)) {

                _favoriteProducts.value -= product
                withContext(Dispatchers.IO) {
                    favoriteProductDao.removeFavorite(productToEntity(product))
                }
            } else {
                _favoriteProducts.value += product
                withContext(Dispatchers.IO) {
                    favoriteProductDao.addFavorite(productToEntity(product))
                }
            }
        }
    }

    private fun productToEntity(product: Product): FavoriteProductEntity {
        return FavoriteProductEntity(
            id = product.id,
            name = product.name,
            imageRes = product.imageRes,
            discountedPrice = product.discountedPrice
        )
    }

    private fun entityToProduct(entity: FavoriteProductEntity): Product {
        return Product(
            id = entity.id,
            name = entity.name,
            imageRes = entity.imageRes,
            originalPrice = 100.0,
            discountedPrice = entity.discountedPrice,
            discountPercentage = 10.0,
            details = "Default details",
            avgReview = 4.5f,
            numReviews = 50,
            deliveryDate = "2023-12-31"
        )
    }

    fun removeFromFavourites(product: Product) {
        viewModelScope.launch {
            _favoriteProducts.value -= product
            withContext(Dispatchers.IO) {
                favoriteProductDao.removeFavorite(productToEntity(product))
            }
        }
    }
}
