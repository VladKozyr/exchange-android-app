package com.vlad.kozyr.architecture.domain.usecase

import com.vlad.kozyr.architecture.domain.CurrencyRepository

class FetchCurrencyUseCase(private val currencyRepository: CurrencyRepository) {
    suspend fun execute() {
        currencyRepository.fetch()
    }
}