plugins {
    alias(libs.plugins.evenly.dev.android.library)
    alias(libs.plugins.evenly.dev.koin)
}

android {
    namespace = "bjoern.kinberger.evenlydevchallenge.data.nearby_places"
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:database"))
}