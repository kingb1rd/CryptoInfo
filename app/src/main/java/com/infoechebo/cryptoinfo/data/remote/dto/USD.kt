package com.infoechebo.cryptoinfo.data.remote.dto


import com.google.gson.annotations.SerializedName

data class USD(
    @SerializedName("ath_date")
    val athDate: String,
    @SerializedName("ath_price")
    val athPrice: Double,
    @SerializedName("market_cap")
    val marketCap: Long,
    @SerializedName("market_cap_change_24h")
    val marketCapChange24h: Double,
    @SerializedName("percent_change_12h")
    val percentChange12h: Double,
    @SerializedName("percent_change_15m")
    val percentChange15m: Double,
    @SerializedName("percent_change_1h")
    val percentChange1h: Double,
    @SerializedName("percent_change_1y")
    val percentChange1y: Double,
    @SerializedName("percent_change_24h")
    val percentChange24h: Double,
    @SerializedName("percent_change_30d")
    val percentChange30d: Double,
    @SerializedName("percent_change_30m")
    val percentChange30m: Double,
    @SerializedName("percent_change_6h")
    val percentChange6h: Double,
    @SerializedName("percent_change_7d")
    val percentChange7d: Double,
    @SerializedName("percent_from_price_ath")
    val percentFromPriceAth: Double,
    val price: Double,
    @SerializedName("volume_24h")
    val volume24h: Double,
    @SerializedName("volume_24h_change_24h")
    val volume24hChange24h: Double
)