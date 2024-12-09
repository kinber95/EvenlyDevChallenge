plugins {
    alias(libs.plugins.evenly.dev.android.library)
    alias(libs.plugins.evenly.dev.koin)
    alias(libs.plugins.evenly.dev.ktor)
}

android {
    namespace = "bjoern.kinberger.evenlydevchallenge.core.network"

    defaultConfig {
        buildConfigField(
            type = "String",
            name = "FOURSQUARE_API_KEY",
            value = "\"${project.findProperty("FOURSQUARE_API_KEY")}\"",
        )
    }

}

dependencies {

}