package com.example.shoppingcart.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.shoppingcart.R
import com.example.shoppingcart.domain.ProductsEvent
import com.example.shoppingcart.viewmodel.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val productViewModel:ProductsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productViewModel.fetchProducts()

        productViewModel.productEvent?.observe(this) { productEvent ->
            when (productEvent) {
                is ProductsEvent.Loading -> {
                    Log.d("Products"," --> Loading")
                }
                ProductsEvent.EmptyList -> {

                }
                is ProductsEvent.Error -> {}
                is ProductsEvent.Success -> {
                    Log.d("Products"," --> "+productEvent.productsList)
                }
            }
        }
    }



}