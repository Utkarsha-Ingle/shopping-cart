package com.example.shoppingcart.component


sealed class ErrorEvent {
    data class APIError(val throwable: Throwable) : ErrorEvent()
    data class ResponseError(val message: String) : ErrorEvent()
}