package com.vlad.kozyr.exchange_api

import com.vlad.kozyr.exchange_api.model.ExchangeRate
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ExchangeApi {
    @GET("/{date}?access_key=$ACCESS_KEY")
    suspend fun getExchangeRateForSpecificDate(@Path("date") date: String): Response<ExchangeRate>

    @GET("/latest?access_key=$ACCESS_KEY")
    suspend fun getLatestExchangeRate(): Response<ExchangeRate>

    companion object {
        const val ACCESS_KEY = "e1b82364e2497ad73e3e714a30c1f393"
    }
}