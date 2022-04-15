package com.example.shoppingcart.component

sealed class ResultType<out T> {
    data class Success<out T>(val value: T) : ResultType<T>()
    data class Error(val state: ErrorState) : ResultType<Nothing>()
}