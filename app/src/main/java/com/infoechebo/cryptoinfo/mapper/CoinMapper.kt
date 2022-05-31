package com.infoechebo.cryptoinfo.mapper

import com.infoechebo.cryptoinfo.data.local.entity.CoinEntity
import com.infoechebo.cryptoinfo.data.remote.dto.CoinDto
import com.infoechebo.cryptoinfo.domain.model.Coin

fun CoinEntity.toCoin(): Coin {
    return Coin(
        coinId = coinId,
        name = name,
        symbol = symbol,
        rank = rank
    )
}

fun Coin.toCoinEntity(): CoinEntity {
    return CoinEntity(
        coinId = coinId,
        name = name,
        symbol = symbol,
        rank = rank
    )
}

fun CoinDto.toCoin(): Coin {
    return Coin(
        coinId = id,
        name = name,
        symbol = symbol,
        rank = rank
    )
}