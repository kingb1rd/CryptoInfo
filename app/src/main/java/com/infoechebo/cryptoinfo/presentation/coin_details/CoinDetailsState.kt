package com.infoechebo.cryptoinfo.presentation.coin_details

import com.infoechebo.cryptoinfo.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coinDetails: CoinDetails? = null,
    val coinPrice: Double? = null,
    val error: String = ""
)