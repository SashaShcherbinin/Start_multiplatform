package feature.splash.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.navigation.navOptions
import base.compose.local.LocalNavigation
import base.compose.view.LoadingView
import feature.dashboard.domain.navigation.NavDashboard
import feature.splash.domain.navigation.NavSplash
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashScreen(viewModel: SplashViewModel = koinViewModel()) {
    val navController = LocalNavigation.current
    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is SplashEvent.NavigateToDashboard -> {
                    val navOptions = navOptions {
                        popUpTo(NavSplash) { inclusive = true }
                    }
                    navController.navigate(
                        NavDashboard,
                        navOptions = navOptions
                    )
                }
            }
        }
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LoadingView()
    }
}
