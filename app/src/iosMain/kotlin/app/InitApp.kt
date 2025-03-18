package app

import androidx.compose.ui.window.ComposeUIViewController

fun initApp() = ComposeUIViewController {
    initKoin()
}