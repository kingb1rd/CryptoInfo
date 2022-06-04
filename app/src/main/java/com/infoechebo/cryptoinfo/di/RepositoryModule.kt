package com.infoechebo.cryptoinfo.di

import com.infoechebo.cryptoinfo.data.repository.CoinRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single {
        CoinRepositoryImpl(get(), get())
    }
}