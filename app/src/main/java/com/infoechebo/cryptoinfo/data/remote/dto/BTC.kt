package com.infoechebo.cryptoinfo.data.remote.dto

import com.google.gson.annotations.SerializedName

data class BTC(
    @SerializedName("ath_date")
    val athDate: Any,
    @SerializedName("ath_price")
    val athPrice: Any,
    @SerializedName("market_cap")
    val marketCap: Int,
    @SerializedName("market_cap_change_24h")
    val marketCapChange24h: Double,
    @SerializedName("percent_change_12h")
    val percentChange12h: Int,
    @SerializedName("percent_change_15m")
    val percentChange15m: Int,
    @SerializedName("percent_change_1h")
    val percentChange1h: Int,
    @SerializedName("percent_change_1y")
    val percentChange1y: Int,
    @SerializedName("percent_change_24h")
    val percentChange24h: Int,
    @SerializedName("percent_change_30d")
    val percentChange30d: Int,
    @SerializedName("percent_change_30m")
    val percentChange30m: Int,
    @SerializedName("percent_change_6h")
    val percentChange6h: Int,
    @SerializedName("percent_change_7d")
    val percentChange7d: Int,
    @SerializedName("percent_from_price_ath")
    val percentFromPriceAth: Any,
    val price: Int,
    @SerializedName("volume_24h")
    val volume24h: Double,
    @SerializedName("volume_24h_change_24h")
    val volume24hChange24h: Double
)