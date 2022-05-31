package com.infoechebo

import android.app.Application
import com.infoechebo.cryptoinfo.di.appModule
import com.infoechebo.cryptoinfo.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CryptoInfoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@CryptoInfoApplication)
            modules(networkModule, appModule)
        }
    }
}