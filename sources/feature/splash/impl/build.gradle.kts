plugins {
    id(libs.plugins.app.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.coroutines.core)
            implementation(libs.compose.navigation)
            implementation(libs.koin.core)
            implementation(libs.koin.compose)

            implementation(projects.base.domain)
            implementation(projects.base.compose)
            implementation(projects.feature.dashboard.api)
            implementation(projects.feature.splash.api)
        }
    }
}
