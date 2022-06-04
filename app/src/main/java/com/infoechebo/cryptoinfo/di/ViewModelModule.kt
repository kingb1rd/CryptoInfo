package com.infoechebo.cryptoinfo.di

import com.infoechebo.cryptoinfo.presentation.coin_details.CoinDetailsViewModel
import com.infoechebo.cryptoinfo.presentation.coin_list.CoinListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        CoinListViewModel(get())
    }

    viewModel {
        CoinDetailsViewModel(get(), get())
    }
}