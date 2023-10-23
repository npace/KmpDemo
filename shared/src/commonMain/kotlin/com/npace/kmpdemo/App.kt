package com.npace.kmpdemo

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.npace.kmpdemo.screen.main.MainScreen

@Composable
fun App() {
    MyApplicationTheme {
        Navigator(
            MainScreen()
        )
    }
}
