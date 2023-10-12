import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    id(libs.plugins.app.application)
    alias(libs.plugins.google.firebase.crashlytics)
}

object Version {
    private const val MAJOR = 1
    private const val MINOR = 0
    private const val PATCH = 0
    const val CODE = MAJOR * 10000 + MINOR * 100 + PATCH
    const val NAME = "$MAJOR.$MINOR.$PATCH"
}

android {
    namespace = "start.project"
    defaultConfig {
        applicationId = "start.project"
        versionCode = Version.CODE
        versionName = Version.NAME
    }
    buildTypes {
        named("release") {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }
}

compose.desktop {
    application {
        mainClass = "app.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "start.project"
            packageVersion = "1.0.0"
        }
    }
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.android.activity)
            implementation(libs.compose.android.ui.tooling.preview)
        }
        commonMain.dependencies {
            implementation(projects.feature.splash.impl)
            implementation(projects.feature.dashboard.impl)
            implementation(projects.feature.user.impl)
            implementation(projects.feature.splash.api)
            implementation(projects.feature.dashboard.api)
            implementation(projects.feature.user.api)
            implementation(projects.base.storage)
            implementation(projects.base.domain)
            implementation(projects.base.logger)
            implementation(projects.base.network)
            implementation(projects.base.compose)

            implementation(libs.compose.navigation)
            implementation(libs.koin.core)
        }
        desktopMain.dependencies {
            implementation(libs.coroutines.jvm)
        }
    }
}
