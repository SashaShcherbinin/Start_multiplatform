package app

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import base.compose.local.LocalNavigation
import base.compose.theme.AppTheme
import feature.dashboard.domain.navigation.NavDashboard
import feature.dashboard.presentation.DashboardScreen
import feature.splash.domain.navigation.NavSplash
import feature.splash.presentation.SplashScreen
import feature.user.domain.navigation.NavUser
import feature.user.presentation.UserScreen

@Composable
fun App() {
    AppTheme {
        Surface {
            val navController = rememberNavController()
            CompositionLocalProvider(LocalNavigation provides navController) {
                NavHost(navController, startDestination = NavSplash) {
                    composable<NavSplash> { SplashScreen() }
                    composable<NavDashboard> { DashboardScreen() }
                    composable<NavUser> { backStackEntry ->
                        UserScreen(
                            userId = backStackEntry.toRoute<NavUser>().userId,
                        )
                    }
                }
            }
        }
    }
}
