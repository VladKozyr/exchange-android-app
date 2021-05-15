package com.vlad.kozyr.architecture.data.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.vlad.kozyr.architecture.data.local.db.CurrencyDataBase
import com.vlad.kozyr.architecture.data.local.db.entity.CurrencyEntity
import com.vlad.kozyr.architecture.data.main.mapper.CurrencyMapper
import com.vlad.kozyr.architecture.domain.CurrencyRepository
import com.vlad.kozyr.architecture.domain.model.Currency
import com.vlad.kozyr.exchange_api.ExchangeRepository

class CurrencyRepositoryImpl(
    private val db: CurrencyDataBase,
    private val apiRepository: ExchangeRepository,
    private val mapper: CurrencyMapper
) :
    CurrencyRepository {
    override fun observe(): LiveData<List<Currency>> {
        return db.currencyDao.observeAllByName()
            .map {
                it.map { currency -> mapper.toModel(currency) }
            }
    }

    override suspend fun fetch() {
        val latestRate = apiRepository.getLatestCurrencyRate()
        val dayBeforeRate = apiRepository.getCurrencyRateDayBefore(latestRate)

        db.currencyDao.insert(
            latestRate.rates.map {
                val rate = (it.value - (dayBeforeRate.rates[it.key] ?: it.value)) / it.value * 100
                CurrencyEntity(it.key, it.value, rate)
            }
        )
    }
}