package com.example.shoppingcart.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingcart.data.Product
import com.example.shoppingcart.databinding.LayoutItemProductBinding

class ProductItemAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            LayoutItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
       return productList.size
    }
}

class ProductViewHolder(private val binding: LayoutItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(product: Product) {
        binding.product = product
    }
}
