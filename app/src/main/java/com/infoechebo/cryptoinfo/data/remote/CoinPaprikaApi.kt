package com.infoechebo.cryptoinfo.data.remote

import com.infoechebo.cryptoinfo.data.remote.dto.CoinDetailsDto
import com.infoechebo.cryptoinfo.data.remote.dto.CoinDto
import com.infoechebo.cryptoinfo.data.remote.dto.CoinTickersDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetails(@Path("coinId") coinId: String): CoinDetailsDto

    @GET("/v1/tickers/{coinId}")
    suspend fun getCoinTickers(@Path("coinId") coinId: String): CoinTickersDto
}