package com.npace.kmpdemo

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController(viewModel: MainViewModel) = ComposeUIViewController { MainScreen(viewModel) }
