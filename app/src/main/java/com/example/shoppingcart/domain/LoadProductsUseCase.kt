package com.example.shoppingcart.domain

import com.example.shoppingcart.component.ErrorEvent
import com.example.shoppingcart.component.ErrorState
import com.example.shoppingcart.component.ResultType
import com.example.shoppingcart.data.Product
import javax.inject.Inject

open class LoadProductsUseCase @Inject constructor(private val iDataRepository: IDataRepository) {

    suspend fun getProducts(): ProductsEvent {
        return when (val response = iDataRepository.getProducts()) {
            is ResultType.Success -> handleProductsResponse(response.value.products)
            is ResultType.Error -> handleErrorResponse(response.state)
        }
    }

    private fun handleErrorResponse(errorState: ErrorState) = when (errorState) {
        is ErrorState.ErrorResponse -> ProductsEvent.Error(ErrorEvent.ResponseError(errorState.message))
        is ErrorState.GenericError -> ProductsEvent.Error(ErrorEvent.APIError(errorState.exception))
        is ErrorState.NetworkError -> ProductsEvent.Error(ErrorEvent.APIError(Throwable(errorState.message)))
    }

    private fun handleProductsResponse(productList: List<Product>?) = if (productList.isNullOrEmpty()) {
        ProductsEvent.EmptyList
    } else {
        ProductsEvent.Success(productList)
    }
}

