package com.infoechebo.cryptoinfo.presentation.coin_list

import com.infoechebo.cryptoinfo.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val isRefreshing: Boolean = false,
    val error: String = ""
)