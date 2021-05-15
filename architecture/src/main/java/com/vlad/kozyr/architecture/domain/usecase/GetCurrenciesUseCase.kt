package com.vlad.kozyr.architecture.domain.usecase

import androidx.lifecycle.LiveData
import com.vlad.kozyr.architecture.domain.CurrencyRepository
import com.vlad.kozyr.architecture.domain.model.Currency

class GetCurrenciesUseCase(private val currencyRepository: CurrencyRepository) {
    fun execute(): LiveData<List<Currency>> {
        return currencyRepository.observe()
    }
}