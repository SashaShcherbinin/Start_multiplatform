plugins {
    id(libs.plugins.app.library)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(libs.coroutines.core)
        implementation(libs.kotlinx.serialization.json)
    }
}
