package com.infoechebo.cryptoinfo.domain.model

data class Coin(
    val coinId: String,
    val name: String,
    val symbol: String,
    val rank: Int,
)