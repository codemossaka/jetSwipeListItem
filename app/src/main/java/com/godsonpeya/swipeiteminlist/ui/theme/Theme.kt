package com.godsonpeya.swipeiteminlist.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val DarkColorScheme = darkColors(
    primary =  Color.Black,
    primaryVariant = Purple700,
    secondary = Teal200,
    onPrimary = Color.White,
)

private val LightColorScheme = lightColors(
    primary =  Color.White,
    primaryVariant = Purple700,
    secondary = Teal200,
    onPrimary = Color.Black,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */)

@Composable
fun SwipeItemInListTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(colors = colors, typography = Typography, shapes = Shapes, content = content)
}