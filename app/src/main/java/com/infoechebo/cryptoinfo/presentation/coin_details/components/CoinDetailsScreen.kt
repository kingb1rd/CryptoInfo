package com.infoechebo.cryptoinfo.presentation.coin_details.components

import androidx.compose.runtime.Composable
import com.infoechebo.cryptoinfo.presentation.coin_details.CoinDetailsViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun CoinDetailsScreen(
) {
    val viewModel = getViewModel<CoinDetailsViewModel>()
    val state = viewModel.state.value


}