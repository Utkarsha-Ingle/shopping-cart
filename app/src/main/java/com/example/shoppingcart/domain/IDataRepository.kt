package com.example.shoppingcart.domain

import com.example.shoppingcart.component.ResultType
import com.example.shoppingcart.data.ProductResponse

interface IDataRepository {
    suspend fun getProducts(): ResultType<ProductResponse>
}