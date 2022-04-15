package com.example.shoppingcart.data

import androidx.room.Entity

data class ProductResponse(
    val products: List<Product>
)

@Entity
data class Product(
    val image_url: String,
    val name: String,
    val price: String,
    val rating: Int
)