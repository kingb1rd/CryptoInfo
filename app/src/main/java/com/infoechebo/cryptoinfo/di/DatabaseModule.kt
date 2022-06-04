package com.infoechebo.cryptoinfo.di

import androidx.room.Room
import com.infoechebo.cryptoinfo.data.local.CryptoInfoDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            CryptoInfoDatabase::class.java,
            "cryptoinfo_db"
        ).build()
    }

    single {
        get<CryptoInfoDatabase>().dao
    }
}