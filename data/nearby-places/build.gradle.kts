plugins {
    alias(libs.plugins.evenly.dev.android.library)
}

android {
    namespace = "bjoern.kinberger.evenlydevchallenge.data.nearby_places"
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:database"))
}