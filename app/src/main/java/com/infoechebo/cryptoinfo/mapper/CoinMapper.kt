package com.infoechebo.cryptoinfo.mapper

import com.infoechebo.cryptoinfo.data.local.entity.CoinEntity
import com.infoechebo.cryptoinfo.data.remote.dto.CoinDetailsDto
import com.infoechebo.cryptoinfo.data.remote.dto.CoinTickersDto
import com.infoechebo.cryptoinfo.domain.model.Coin
import com.infoechebo.cryptoinfo.domain.model.CoinDetails

fun CoinEntity.toCoin(): Coin {
    return Coin(
        coinId = coinId,
        name = name,
        symbol = symbol,
        rank = rank,
        price = price
    )
}

fun CoinTickersDto.toCoin(): Coin {
    return Coin(
        coinId = id,
        name = name,
        symbol = symbol,
        rank = rank,
        price = quotes.uSD.price.round()
    )
}

fun CoinTickersDto.toCoinEntity(): CoinEntity {
    return CoinEntity(
        coinId = id,
        name = name,
        symbol = symbol,
        rank = rank,
        price = quotes.uSD.price.round()
    )
}

fun CoinDetailsDto.toCoinDetails(): CoinDetails {
    return CoinDetails(
        description = description,
        isNew = isNew,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}

fun Double.round(decimals: Int = 2): Double = "%.${decimals}f".format(this).toDouble()