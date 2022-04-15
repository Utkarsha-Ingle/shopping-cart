package com.example.shoppingcart.data

import com.example.shoppingcart.component.safeApiCall
import com.example.shoppingcart.domain.IDataRepository
import javax.inject.Inject

class ProductsService @Inject constructor(private val api: ProductsApi): IDataRepository {
    override suspend fun getProducts() = safeApiCall { api.getProducts() }
}