package com.vlad.kozyr.exchange_api.model

import java.util.*

data class ExchangeRate(
    val base: String,
    val date: Date,
    val rates: Map<String, Double>,
    val success: Boolean,
    val timestamp: Int
)