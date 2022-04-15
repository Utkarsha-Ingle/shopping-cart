package com.example.shoppingcart.domain
import com.example.shoppingcart.component.ErrorEvent
import com.example.shoppingcart.data.Product

sealed class ProductsEvent {
    data class Success(val productsList: List<Product>) : ProductsEvent()
    object EmptyList : ProductsEvent()
    object Loading : ProductsEvent()
    data class Error(val errorEvent: ErrorEvent) : ProductsEvent()
}