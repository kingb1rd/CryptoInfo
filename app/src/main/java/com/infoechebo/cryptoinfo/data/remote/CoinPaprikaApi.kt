package com.infoechebo.cryptoinfo.data.remote

import com.infoechebo.cryptoinfo.data.remote.dto.CoinDetailsDto
import com.infoechebo.cryptoinfo.data.remote.dto.CoinDto
import com.infoechebo.cryptoinfo.data.remote.dto.CoinTickersDto
import retrofit2.http.GET

interface CoinPaprikaApi {
    @GET
    suspend fun getCoins(): List<CoinDto>

    @GET
    suspend fun getCoinDetails(coinId: String): CoinDetailsDto

    @GET
    suspend fun getCoinTickers(coinId: String): CoinTickersDto
}