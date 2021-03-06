package com.infoechebo.cryptoinfo.presentation.coin_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.infoechebo.cryptoinfo.presentation.ScreenRoute
import com.infoechebo.cryptoinfo.presentation.UiEvent
import com.infoechebo.cryptoinfo.presentation.coin_list.CoinListViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel

@Composable
fun CoinListScreen(
    navController: NavController,
) {
    val viewModel = getViewModel<CoinListViewModel>()
    val state = viewModel.state.value
    val isRefreshing = viewModel.state.value.isRefreshing

    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        event.message
                    )
                }
            }
        }
    }

    Scaffold(scaffoldState = scaffoldState) { paddingValues ->
        paddingValues.calculateBottomPadding()

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            TextField(
                value = viewModel.searchQuery.value,
                onValueChange = viewModel::onSearch,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                maxLines = 1,
                placeholder = {
                    Text(text = "Search...")
                }
            )

            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing),
                onRefresh = { viewModel.onRefresh() }
            ) {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 62.dp)
                ) {
                    items(state.coins) { coin ->
                        CoinItem(coin = coin, onItemClick = {
                            navController.navigate(ScreenRoute.CoinDetailsScreenRoute.route + "/${coin.coinId}")
                        })
                    }
                }
            }

            if (state.isLoading)
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}