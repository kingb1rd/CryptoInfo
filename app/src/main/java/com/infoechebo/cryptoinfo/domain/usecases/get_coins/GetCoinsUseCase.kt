package com.infoechebo.cryptoinfo.domain.usecases.get_coins

import com.infoechebo.cryptoinfo.common.Resource
import com.infoechebo.cryptoinfo.domain.model.Coin
import com.infoechebo.cryptoinfo.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class GetCoinsUseCase(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> {
        return repository.getCoinsTickers()
    }
}