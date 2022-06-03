package com.infoechebo.cryptoinfo.presentation.coin_details

import com.infoechebo.cryptoinfo.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = ""
)