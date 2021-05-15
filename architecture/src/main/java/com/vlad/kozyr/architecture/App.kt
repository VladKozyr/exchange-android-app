package com.vlad.kozyr.architecture

import android.app.Application
import com.vlad.kozyr.architecture.core.di.ModuleProvider
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(ModuleProvider.modules)
        }
    }
}