package com.d00042423.parcial_2.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(dummyPetList)
    val filteredPets: StateFlow<List<Pet>> = _pets

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    fun getPetById(id: Int): Pet? = _pets.value.find { it.id == id }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        val filtered = dummyPetList.filter {
            it.name.contains(query, ignoreCase = true) || it.type.contains(query, ignoreCase = true)
        }
        _pets.value = filtered
    }
}