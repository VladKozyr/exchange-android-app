package com.vlad.kozyr.exchange_api.model

sealed class Result<T> {
    data class Success<T>(val value: T) : Result<T>()
    data class Error<T>(val statusCode: Int, val message: String) : Result<T>()
}