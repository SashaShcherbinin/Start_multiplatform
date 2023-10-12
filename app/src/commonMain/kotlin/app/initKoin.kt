package app

import base.logger.di.loggerModule
import base.network.module.networkModule
import feature.dashboard.di.featureDashboardModule
import feature.splash.di.featureSplashModule
import feature.user.di.featureUserModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            loggerModule(),
            networkModule(),
            featureSplashModule(),
            featureDashboardModule(),
            featureUserModule(),
        )
    }
}