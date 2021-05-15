package com.vlad.kozyr.exchange_api

import android.annotation.SuppressLint
import com.vlad.kozyr.exchange_api.model.ExchangeRate
import com.vlad.kozyr.network.handleResponse
import java.text.SimpleDateFormat
import java.util.*

class ExchangeRepository(private val exchangeApi: ExchangeApi) {
    suspend fun getLatestCurrencyRate(): ExchangeRate {
        return exchangeApi.getLatestExchangeRate().handleResponse()
    }

    @SuppressLint("SimpleDateFormat")
    suspend fun getCurrencyRateDayBefore(exchangeRate: ExchangeRate): ExchangeRate {
        val date = exchangeRate.date
        val calendar = Calendar.getInstance().apply {
            time = date
            add(Calendar.DAY_OF_YEAR, -1)
        }
        return exchangeApi.getExchangeRateForSpecificDate(
            SimpleDateFormat("yyyy-MM-dd").format(
                calendar.time
            )
        ).handleResponse()
    }
}