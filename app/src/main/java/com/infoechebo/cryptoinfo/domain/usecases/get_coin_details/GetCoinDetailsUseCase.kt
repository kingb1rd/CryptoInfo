package com.infoechebo.cryptoinfo.domain.usecases.get_coin_details

import com.infoechebo.cryptoinfo.common.Resource
import com.infoechebo.cryptoinfo.domain.model.CoinDetails
import com.infoechebo.cryptoinfo.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class GetCoinDetailsUseCase(private val repository: CoinRepository, private val coinId: String) {
    suspend operator fun invoke(): Flow<Resource<CoinDetails>> {
        return repository.getCoinDetails(coinId)
    }
}