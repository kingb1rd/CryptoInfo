package com.infoechebo.cryptoinfo.presentation

sealed class UiEvent {
    data class ShowSnackbar(val message: String) : UiEvent()
}