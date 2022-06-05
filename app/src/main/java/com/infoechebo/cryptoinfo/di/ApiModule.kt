package com.infoechebo.cryptoinfo.di

import com.infoechebo.cryptoinfo.common.Constants
import com.infoechebo.cryptoinfo.data.remote.CoinPaprikaApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }
}