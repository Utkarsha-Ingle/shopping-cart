package com.example.shoppingcart.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun loadImage(view: ImageView,url: String) {
    Glide.with(view.context)
        .load(url)
        .centerCrop()
        .into(view)
}

@BindingAdapter("price")
fun price(view: TextView, price: String) {
    """Price : ${price}₹""".also { view.text = it }
}

@BindingAdapter("ratings")
fun ratings(view: TextView, rating: Int) {
    """Ratings : ${rating}/5""".also { view.text = it }
}