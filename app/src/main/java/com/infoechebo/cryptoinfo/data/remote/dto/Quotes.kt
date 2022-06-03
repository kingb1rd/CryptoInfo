package com.infoechebo.cryptoinfo.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Quotes(
    @SerializedName("BTC")
    val bTC: BTC,
    @SerializedName("USD")
    val uSD: USD
)