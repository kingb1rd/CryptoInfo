package com.infoechebo.cryptoinfo.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val ColorPalette = lightColors(
    primary = ColorPrimary,
    background = DarkGray,
    onBackground = TextWhite,
    onPrimary = DarkGray
)

@Composable
fun CryptoInfoTheme(content: @Composable () -> Unit) {
    val colors = ColorPalette

    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(
        color = Color(0xFF202020)
    )

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}