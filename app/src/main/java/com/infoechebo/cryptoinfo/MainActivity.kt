package com.infoechebo.cryptoinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.infoechebo.cryptoinfo.common.Constants.PARAM_COIN_ID
import com.infoechebo.cryptoinfo.presentation.ScreenRoute
import com.infoechebo.cryptoinfo.presentation.coin_details.components.CoinDetailsScreen
import com.infoechebo.cryptoinfo.presentation.coin_list.components.CoinListScreen
import com.infoechebo.cryptoinfo.presentation.ui.theme.CryptoInfoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoInfoTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoute.CoinListScreenRoute.route
                    ) {
                        composable(
                            route = ScreenRoute.CoinListScreenRoute.route
                        ) {
                            CoinListScreen(navController)
                        }

                        composable(
                            route = ScreenRoute.CoinDetailsScreenRoute.route + "/{$PARAM_COIN_ID}"
                        ) {
                            CoinDetailsScreen(navController)
                        }
                    }
                }
            }
        }
    }
}