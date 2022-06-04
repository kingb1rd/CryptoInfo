package com.infoechebo.cryptoinfo.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CoinEntity(
    @PrimaryKey
    val id: Int? = null,
    val coinId: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val price: Double
)