package com.example.shoppingcart.data

import retrofit2.Response
import retrofit2.http.GET

interface ProductsApi {
    @GET("nancymadan/assignment/db")
    suspend fun getProducts(): Response<ProductResponse>
}