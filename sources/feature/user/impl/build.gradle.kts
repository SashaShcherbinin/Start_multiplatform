plugins {
    id(libs.plugins.app.compose)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.image.async)
            implementation(libs.compose.navigation)
            implementation(libs.coroutines.core)
            implementation(libs.koin.core)
            implementation(libs.koin.compose)

            implementation(libs.bundles.network)
            implementation(libs.kotlinx.serialization.json)

            implementation(projects.base.compose)
            implementation(projects.base.domain)
            implementation(projects.base.logger)
            implementation(projects.base.storage)
            implementation(projects.feature.user.api)
            implementation(projects.feature.dashboard.api)
        }
    }
}
