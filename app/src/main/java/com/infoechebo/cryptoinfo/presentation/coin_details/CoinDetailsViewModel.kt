package com.infoechebo.cryptoinfo.presentation.coin_details

import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.infoechebo.cryptoinfo.common.Constants.PARAM_COIN_ID
import com.infoechebo.cryptoinfo.common.Resource
import com.infoechebo.cryptoinfo.domain.usecases.get_coin_details.GetCoinDetailsUseCase
import com.infoechebo.cryptoinfo.presentation.UiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class CoinDetailsViewModel(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    arguments: Bundle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        arguments.getString(PARAM_COIN_ID)?.let { coinId ->
            getCoinDetails(coinId)
        }
    }

    private fun getCoinDetails(coinId: String) {
        getCoinDetailsUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailsState(coinDetails = result.data)
                }
                is Resource.Error -> {
                    _eventFlow.emit(
                        UiEvent.ShowSnackbar(
                            message = result.message ?: "Unknown error"
                        )
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}