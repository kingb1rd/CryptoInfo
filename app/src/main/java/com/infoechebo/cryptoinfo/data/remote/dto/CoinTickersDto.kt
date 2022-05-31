package com.infoechebo.cryptoinfo.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CoinTickersDto(
    @SerializedName("beta_value")
    val betaValue: Double,
    @SerializedName("circulating_supply")
    val circulatingSupply: Int,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    val id: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("max_supply")
    val maxSupply: Int,
    val name: String,
    val quotes: Quotes,
    val rank: Int,
    val symbol: String,
    @SerializedName("total_supply")
    val totalSupply: Int
)