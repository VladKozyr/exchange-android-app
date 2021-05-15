package com.vlad.kozyr.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    const val BASE_URL = "http://api.exchangeratesapi.io/v1/"

    val retrofitModule = module {
        single {
            provideRetrofitClient(
                okHttpClient = get(),
                url = BASE_URL
            )
        }

        factory {
            provideOkHttpClient()
        }
    }

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                })
            .build()
    }

    private fun provideRetrofitClient(okHttpClient: OkHttpClient, url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}