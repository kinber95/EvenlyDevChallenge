import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "bjoern.kinberger.build_logic.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "bjoern.kinberger.evenlydevchallenge.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "bjoern.kinberger.evenlydevchallenge.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "bjoern.kinberger.evenlydevchallenge.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("koin") {
            id = "bjoern.kinberger.evenlydevchallenge.koin"
            implementationClass = "KoinConventionPlugin"
        }
        register("ktor") {
            id = "bjoern.kinberger.evenlydevchallenge.ktor"
            implementationClass = "KtorConventionPlugin"
        }
    }
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}