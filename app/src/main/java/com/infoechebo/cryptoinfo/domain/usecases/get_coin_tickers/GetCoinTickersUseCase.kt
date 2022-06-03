package com.infoechebo.cryptoinfo.domain.usecases.get_coin_tickers

import com.infoechebo.cryptoinfo.common.Resource
import com.infoechebo.cryptoinfo.domain.model.CoinPrice
import com.infoechebo.cryptoinfo.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class GetCoinTickersUseCase(private val repository: CoinRepository, private val coinId: String) {
    suspend operator fun invoke(): Flow<Resource<CoinPrice>> {
        return repository.getCoinTickers(coinId)
    }
}