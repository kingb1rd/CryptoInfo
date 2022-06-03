package com.infoechebo.cryptoinfo.domain.repository

import com.infoechebo.cryptoinfo.common.Resource
import com.infoechebo.cryptoinfo.domain.model.Coin
import com.infoechebo.cryptoinfo.domain.model.CoinDetails
import com.infoechebo.cryptoinfo.domain.model.CoinPrice
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    fun getCoins(): Flow<Resource<List<Coin>>>
    suspend fun getCoinDetails(coinId: String): Flow<Resource<CoinDetails>>
    suspend fun getCoinTickers(coinId: String): Flow<Resource<CoinPrice>>
}