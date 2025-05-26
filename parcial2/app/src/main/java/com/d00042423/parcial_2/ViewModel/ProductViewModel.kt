package com.d00042423.parcial_2.ViewModel

import androidx.lifecycle.ViewModel
import com.d00042423.parcial_2.DummyData.ObtenerProduct
import com.d00042423.parcial_2.Model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(ObtenerProduct)
    val filteredPets: StateFlow<List<Product>> = _products

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    fun getProductById(id: Int): Product? = _products.value.find { it.id == id }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        val filtered = ObtenerProduct().filter {
            it.name.contains(query, ignoreCase = true) || it.type.contains(query, ignoreCase = true)
        }
        _products.value = filtered
    }
}