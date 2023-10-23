package com.npace.kmpdemo

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator

@Composable
fun App() {
    MyApplicationTheme {
        Navigator(
            MainScreen()
        )
    }
}
