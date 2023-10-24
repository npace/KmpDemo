package com.npace.kmpdemo

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.npace.kmpdemo.screen.main.MainScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun App() {
    MyApplicationTheme {
        Navigator(MainScreen()) {
            SlideTransition(it)
        }
    }
}
