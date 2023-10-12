plugins {
    id(libs.plugins.app.library)
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                implementation(libs.google.firebase.crashlytics.ktx)
            }
        }
        commonMain.dependencies {
            implementation(projects.base.domain)
            implementation(libs.koin.core)
        }
    }
}
