plugins {
    id(libs.plugins.app.library)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.base.domain)
            implementation(projects.base.logger)

            implementation(libs.bundles.network)
            implementation(libs.koin.core)
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.android)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.ios)
        }
        desktopMain.dependencies {
            implementation(libs.ktor.client.jvm)
        }
    }
}
