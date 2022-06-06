package com.infoechebo.cryptoinfo.domain.repository

import com.infoechebo.cryptoinfo.common.Resource
import com.infoechebo.cryptoinfo.domain.model.Coin
import com.infoechebo.cryptoinfo.domain.model.CoinDetails
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    fun getCoinsTickers(
        query: String? = ""
    ): Flow<Resource<List<Coin>>>

    fun getCoinDetails(coinId: String): Flow<Resource<CoinDetails>>
}