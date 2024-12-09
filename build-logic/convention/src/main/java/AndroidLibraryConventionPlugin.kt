import bjoern.kinberger.evenlydevchallenge.build_logic.convention.config.configureAndroidCompose
import bjoern.kinberger.evenlydevchallenge.build_logic.convention.config.configureKotlinAndroid
import bjoern.kinberger.evenlydevchallenge.build_logic.convention.ext.implementation
import bjoern.kinberger.evenlydevchallenge.build_logic.convention.ext.libs
import bjoern.kinberger.evenlydevchallenge.build_logic.convention.ext.testImplementation
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.compose")
                apply("bjoern.kinberger.evenlydevchallenge.ktor")
                apply("bjoern.kinberger.evenlydevchallenge.koin")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                configureAndroidCompose(this)
                defaultConfig.targetSdk = 34
            }

            dependencies {
                implementation(libs.findLibrary("androidx-lifecycle-runtime-ktx").get())
                implementation(libs.findLibrary("androidx-core-ktx").get())
                implementation(libs.findLibrary("kotlinx-coroutines-core").get())
                implementation(libs.findLibrary("kotlinx-serialization-json").get())
                implementation(libs.findLibrary("arrow-core").get())

                testImplementation(kotlin("test"))
            }
        }
    }
}