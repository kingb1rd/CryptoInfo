package com.infoechebo.cryptoinfo.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.infoechebo.cryptoinfo.common.Constants
import com.infoechebo.cryptoinfo.common.Resource
import com.infoechebo.cryptoinfo.domain.usecases.get_coin_details.GetCoinDetailsUseCase
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class CoinDetailsViewModel(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
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
        viewModelScope.launch {
            getCoinDetailsUseCase(coinId).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = CoinDetailsState(coinDetails = result.data)
                    }
                    is Resource.Error -> {
                        _state.value = CoinDetailsState(
                            error = result.message ?: "Unexpected error ocurred"
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = CoinDetailsState(isLoading = true)
                    }
                }
            }
        }
    }
}