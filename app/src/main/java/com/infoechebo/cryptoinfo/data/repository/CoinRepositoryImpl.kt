package com.infoechebo.cryptoinfo.data.repository

import com.infoechebo.cryptoinfo.data.remote.dto.CoinDetailsDto
import com.infoechebo.cryptoinfo.data.remote.dto.CoinDto
import com.infoechebo.cryptoinfo.data.remote.dto.CoinTickersDto
import com.infoechebo.cryptoinfo.domain.repository.CoinRepository

class CoinRepositoryImpl : CoinRepository {
    override suspend fun getCoin(): List<CoinDto> {

    }

    override suspend fun getCoinDetails(): CoinDetailsDto {

    }

    override suspend fun getCoinTickers(): CoinTickersDto {

    }
}