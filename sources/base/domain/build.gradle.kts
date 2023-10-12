plugins {
    id(libs.plugins.app.library)
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(libs.koin.core)
        implementation(libs.coroutines.core)
    }
}