package com.infoechebo.cryptoinfo.data.repository

import com.infoechebo.cryptoinfo.common.Resource
import com.infoechebo.cryptoinfo.data.local.CoinDao
import com.infoechebo.cryptoinfo.data.remote.CoinPaprikaApi
import com.infoechebo.cryptoinfo.domain.model.Coin
import com.infoechebo.cryptoinfo.domain.model.CoinDetails
import com.infoechebo.cryptoinfo.domain.repository.CoinRepository
import com.infoechebo.cryptoinfo.mapper.toCoin
import com.infoechebo.cryptoinfo.mapper.toCoinDetails
import com.infoechebo.cryptoinfo.mapper.toCoinEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class CoinRepositoryImpl(
    private val api: CoinPaprikaApi,
    private val dao: CoinDao
) : CoinRepository {

    override fun getCoinsTickers(
        query: String?
    ): Flow<Resource<List<Coin>>> = flow {

        if (!query.isNullOrEmpty()) {
            emit(Resource.Loading())
            val localCoins = dao.searchCoins(query).map { it.toCoin() }
            emit(Resource.Loading(data = localCoins))
            emit(Resource.Success(localCoins))
            return@flow
        }

        emit(Resource.Loading())
        val localCoins = dao.getCoins().map { it.toCoin() }
        emit(Resource.Loading(data = localCoins))

        try {
            val remoteCoins = api.getCoinsTickers()
            dao.deleteCoins()
            dao.insertCoins(remoteCoins.map { it.toCoinEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Oops, something went wrong", data = localCoins))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach the server. Check your internet connection",
                    data = localCoins
                )
            )
        }

        val newCoins = dao.getCoins().map { it.toCoin() }
        emit(Resource.Success(newCoins))
    }

    override fun getCoinDetails(coinId: String): Flow<Resource<CoinDetails>> = flow {
        emit(Resource.Loading())
        try {
            val remoteCoinDetails = api.getCoinDetails(coinId)
            emit(Resource.Success(data = remoteCoinDetails.toCoinDetails()))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Oops, something went wrong"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach the server. Check your internet connection"))
        }
    }
}