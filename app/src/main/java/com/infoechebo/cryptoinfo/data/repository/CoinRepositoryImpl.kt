package com.infoechebo.cryptoinfo.data.repository

import com.infoechebo.cryptoinfo.data.remote.CoinPaprikaApi
import com.infoechebo.cryptoinfo.data.remote.dto.CoinDetailsDto
import com.infoechebo.cryptoinfo.data.remote.dto.CoinDto
import com.infoechebo.cryptoinfo.data.remote.dto.CoinTickersDto
import com.infoechebo.cryptoinfo.domain.repository.CoinRepository

class CoinRepositoryImpl(private val api: CoinPaprikaApi) : CoinRepository {
    override suspend fun getCoin(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinDetails(coinId: String): CoinDetailsDto {
        return api.getCoinDetails(coinId)
    }

    override suspend fun getCoinTickers(coinId: String): CoinTickersDto {
        return api.getCoinTickers(coinId)
    }
}