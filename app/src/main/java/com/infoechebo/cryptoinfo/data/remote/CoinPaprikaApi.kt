package com.infoechebo.cryptoinfo.data.remote

import com.infoechebo.cryptoinfo.data.remote.dto.CoinDetailsDto
import com.infoechebo.cryptoinfo.data.remote.dto.CoinTickersDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/tickers")
    suspend fun getCoinsTickers(): List<CoinTickersDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetails(@Path("coinId") coinId: String): CoinDetailsDto
}