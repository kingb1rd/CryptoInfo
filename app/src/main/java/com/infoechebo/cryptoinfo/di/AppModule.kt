package com.infoechebo.cryptoinfo.di

import com.infoechebo.cryptoinfo.data.repository.CoinRepositoryImpl
import com.infoechebo.cryptoinfo.domain.repository.CoinRepository
import org.koin.androidx.compose.get
import org.koin.androidx.compose.viewModel
import org.koin.dsl.module

val appModule = module {
    single<CoinRepository> {
        CoinRepositoryImpl(get())
    }

//    viewModel {
//        MainViewModel(get())
//    }
}