package com.infoechebo.cryptoinfo.presentation

sealed class ScreenRoute(val route: String) {
    object CoinListScreenRoute: ScreenRoute("coin_list_screen")
    object CoinDetailsScreenRoute: ScreenRoute("coin_details_screen")
}