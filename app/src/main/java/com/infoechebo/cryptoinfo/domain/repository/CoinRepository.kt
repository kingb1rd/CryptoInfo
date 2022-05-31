package com.infoechebo.cryptoinfo.domain.repository

import com.infoechebo.cryptoinfo.data.remote.dto.CoinDetailsDto
import com.infoechebo.cryptoinfo.data.remote.dto.CoinDto
import com.infoechebo.cryptoinfo.data.remote.dto.CoinTickersDto

interface CoinRepository {
    suspend fun getCoin(): List<CoinDto>
    suspend fun getCoinDetails(): CoinDetailsDto
    suspend fun getCoinTickers(): CoinTickersDto
}