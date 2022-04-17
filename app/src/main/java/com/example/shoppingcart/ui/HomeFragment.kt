package com.example.shoppingcart.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingcart.data.Product
import com.example.shoppingcart.databinding.FragmentProductsBinding
import com.example.shoppingcart.domain.ProductsEvent
import com.example.shoppingcart.viewmodel.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val productViewModel: ProductsViewModel by viewModels()
    private lateinit var fragmentProductBinding: FragmentProductsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentProductBinding = FragmentProductsBinding.inflate(inflater)
        return fragmentProductBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData() {

        productViewModel.fetchProducts()

        productViewModel.productEvent.observe(viewLifecycleOwner) { productEvent ->
            when (productEvent) {
                is ProductsEvent.Loading -> {
                    Log.d("Products", " --> Loading")
                }
                ProductsEvent.EmptyList -> {

                }
                is ProductsEvent.Error -> {}
                is ProductsEvent.Success -> {
                    setProductList(productEvent.productsList)
                    Log.d("Products", " --> " + productEvent.productsList)
                }
            }
        }
    }

    private fun setProductList(productsList: List<Product>) {
        val productAdapter = ProductItemAdapter(productsList)
        fragmentProductBinding.rvProducts.adapter = productAdapter
        fragmentProductBinding.rvProducts.layoutManager = LinearLayoutManager(requireContext())
        fragmentProductBinding.rvProducts.setHasFixedSize(true)
    }
}