package com.vlad.kozyr.network

import retrofit2.Response

fun <T> Response<T>.handleResponse(): T {
    check(isSuccessful && body() != null) { message() }
    return body()!!
}