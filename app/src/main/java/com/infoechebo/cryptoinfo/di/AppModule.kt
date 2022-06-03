package com.infoechebo.cryptoinfo.di

import androidx.room.Room
import com.infoechebo.cryptoinfo.data.local.CryptoInfoDatabase
import com.infoechebo.cryptoinfo.data.repository.CoinRepositoryImpl
import com.infoechebo.cryptoinfo.domain.repository.CoinRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single<CoinRepository> {
        CoinRepositoryImpl(get(), get())
    }

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

//    viewModel {
//        MainViewModel(get())
//    }
}