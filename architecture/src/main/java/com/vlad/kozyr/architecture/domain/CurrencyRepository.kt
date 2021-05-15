package com.vlad.kozyr.architecture.domain

import androidx.lifecycle.LiveData
import com.vlad.kozyr.architecture.domain.model.Currency

interface CurrencyRepository {
    fun observe(): LiveData<List<Currency>>

    suspend fun fetch()
}