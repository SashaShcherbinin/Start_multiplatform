plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
    alias(libs.plugins.kotlin.serialization)
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven(url = "https://plugins.gradle.org/m2/")
}

dependencies {
    implementation(libs.gradle.android)
    implementation(libs.gradle.kotlin)
    implementation(libs.gradle.kotlin.compose)
    implementation(libs.gradle.compose.compiler)
    implementation(libs.gradle.kotlin.multiplatform)

    implementation(libs.kotlin.xml.builder)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.network)
}
