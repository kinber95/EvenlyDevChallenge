import bjoern.kinberger.evenlydevchallenge.build_logic.convention.ext.implementation

plugins {
    alias(libs.plugins.evenly.dev.android.library)
    alias(libs.plugins.evenly.dev.koin)
}

android {
    namespace = "bjoern.kinberger.evenlydevchallenge.feature.poi_browser"
}

dependencies {
    implementation(project(":core:navigation"))
    implementation(project(":data:nearby-places"))
}