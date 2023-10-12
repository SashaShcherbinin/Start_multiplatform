plugins {
    id(libs.plugins.app.library)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.coroutines.core)
            implementation(libs.kotlinx.datetime)
        }
//        commonTest.dependencies {
//            implementation(libs.bundles.test.common)
//        }
    }
}
