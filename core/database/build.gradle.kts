plugins {
    alias(libs.plugins.evenly.dev.android.library)
}

android {
    namespace = "bjoern.kinberger.evenlydevchallenge.core.database"
}

dependencies {
    implementation(libs.bundles.room)
    ksp(libs.room.compiler)
}