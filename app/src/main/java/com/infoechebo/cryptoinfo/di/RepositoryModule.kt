package com.infoechebo.cryptoinfo.di

import com.infoechebo.cryptoinfo.data.repository.CoinRepositoryImpl
import com.infoechebo.cryptoinfo.domain.repository.CoinRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CoinRepository> {
        CoinRepositoryImpl(get(), get())
    }
}