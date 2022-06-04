package com.infoechebo.cryptoinfo.di

import androidx.room.Room
import com.infoechebo.cryptoinfo.data.local.CryptoInfoDatabase
import com.infoechebo.cryptoinfo.data.repository.CoinRepositoryImpl
import com.infoechebo.cryptoinfo.domain.usecases.get_coin_details.GetCoinDetailsUseCase
import com.infoechebo.cryptoinfo.domain.usecases.get_coins.GetCoinsUseCase
import com.infoechebo.cryptoinfo.presentation.coin_details.CoinDetailsViewModel
import com.infoechebo.cryptoinfo.presentation.coin_list.CoinListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            CryptoInfoDatabase::class.java,
            "cryptoinfo_db"
        ).build()
    }

    single {
        val db = get<CryptoInfoDatabase>()
        db.dao
    }

    single {
        CoinRepositoryImpl(get(), get())
    }

    single {
        GetCoinDetailsUseCase(get())
    }

    single {
        GetCoinsUseCase(get())
    }

    viewModel {
        CoinListViewModel(get())
    }

    viewModel {
        CoinDetailsViewModel(get(), get())
    }
}