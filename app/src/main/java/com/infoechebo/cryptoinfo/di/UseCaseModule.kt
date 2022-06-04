package com.infoechebo.cryptoinfo.di

import com.infoechebo.cryptoinfo.domain.usecases.get_coin_details.GetCoinDetailsUseCase
import com.infoechebo.cryptoinfo.domain.usecases.get_coins.GetCoinsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single {
        GetCoinDetailsUseCase(get())
    }

    single {
        GetCoinsUseCase(get())
    }
}