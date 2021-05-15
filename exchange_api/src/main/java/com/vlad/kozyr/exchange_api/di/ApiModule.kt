package com.vlad.kozyr.exchange_api.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vlad.kozyr.exchange_api.ExchangeApi
import com.vlad.kozyr.exchange_api.ExchangeRepository
import com.vlad.kozyr.network.NetworkModule
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val exchangeApiModule = module {
    single { ExchangeRepository(exchangeApi = get()) }
    single {
        provideRetrofit(okHttpClient = get()).create(ExchangeApi::class.java)
    }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val gson = provideGson()
    return Retrofit.Builder()
        .baseUrl(NetworkModule.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}

fun provideGson(): Gson {
    return GsonBuilder()
        .setDateFormat("yyyy-MM-dd")
        .create()
}
