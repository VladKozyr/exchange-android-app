package com.vlad.kozyr.architecture.core.di

import androidx.room.Room
import com.vlad.kozyr.architecture.data.local.db.CurrencyDataBase
import com.vlad.kozyr.architecture.data.main.CurrencyRepositoryImpl
import com.vlad.kozyr.architecture.data.main.mapper.CurrencyMapper
import com.vlad.kozyr.architecture.domain.CurrencyRepository
import com.vlad.kozyr.architecture.domain.usecase.FetchCurrencyUseCase
import com.vlad.kozyr.architecture.domain.usecase.GetCurrenciesUseCase
import com.vlad.kozyr.architecture.presentation.CurrencyViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {

    single {
        Room.databaseBuilder(androidContext(), CurrencyDataBase::class.java, "currencies")
            .build()
    }

    single {
        CurrencyRepositoryImpl(
            db = get(),
            mapper = get(),
            apiRepository = get()
        )
    } bind CurrencyRepository::class

    single {
        CurrencyViewModel(
            getCurrenciesUseCase = get(),
            fetchCurrencyUseCase = get()
        )
    }

    factory { CurrencyMapper() }
    factory { GetCurrenciesUseCase(currencyRepository = get()) }
    factory { FetchCurrencyUseCase(currencyRepository = get()) }
}