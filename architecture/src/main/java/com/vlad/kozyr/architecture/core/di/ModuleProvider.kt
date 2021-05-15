package com.vlad.kozyr.architecture.core.di

import com.vlad.kozyr.exchange_api.di.exchangeApiModule
import com.vlad.kozyr.network.NetworkModule
import org.koin.core.module.Module

object ModuleProvider {
    val modules: List<Module>
        get() {
            return appModule + NetworkModule.retrofitModule + exchangeApiModule
        }
}
