package com.infoechebo.cryptoinfo.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.infoechebo.cryptoinfo.common.Constants
import com.infoechebo.cryptoinfo.common.Resource
import com.infoechebo.cryptoinfo.domain.usecases.get_coin_details.GetCoinDetailsUseCase
import com.infoechebo.cryptoinfo.domain.usecases.get_coin_tickers.GetCoinTickersUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CoinDetailsViewModel(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    private val getCoinTickersUseCase: GetCoinTickersUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoinDetailsAndPrice(coinId)
        }
    }

    private fun getCoinDetailsAndPrice(coinId: String) {
        getCoinDetailsUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {

                }
                is Resource.Success -> {

                }
                is Resource.Success -> {

                }
            }
        }.launchIn(viewModelScope)
    }
}