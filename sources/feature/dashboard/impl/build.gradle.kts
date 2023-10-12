plugins {
    id(libs.plugins.app.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.image.async)
            implementation(libs.compose.image.ktor)
            implementation(libs.compose.navigation)
            implementation(libs.coroutines.core)
            implementation(libs.koin.core)
            implementation(libs.koin.compose)

            implementation(projects.base.domain)
            implementation(projects.base.compose)
            implementation(projects.base.logger)
            implementation(projects.feature.dashboard.api)
            implementation(projects.feature.splash.api)
            implementation(projects.feature.user.api)
        }
    }
}
