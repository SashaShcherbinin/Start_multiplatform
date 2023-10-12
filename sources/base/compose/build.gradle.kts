plugins {
    id(libs.plugins.app.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.navigation)
            implementation(libs.coroutines.core)
        }
    }
}
