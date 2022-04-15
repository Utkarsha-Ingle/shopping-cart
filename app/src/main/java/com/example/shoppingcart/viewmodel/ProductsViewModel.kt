package com.example.shoppingcart.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingcart.domain.LoadProductsUseCase
import com.example.shoppingcart.domain.ProductsEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val loadProductsUseCase: LoadProductsUseCase) : ViewModel() {
    private val _productEvent = MutableLiveData<ProductsEvent>()
    val productEvent: LiveData<ProductsEvent>
        get() = _productEvent


    fun fetchProducts() {
        _productEvent.postValue(ProductsEvent.Loading)
        viewModelScope.launch {
            _productEvent.postValue(loadProductsUseCase.getProducts())
        }
    }

}