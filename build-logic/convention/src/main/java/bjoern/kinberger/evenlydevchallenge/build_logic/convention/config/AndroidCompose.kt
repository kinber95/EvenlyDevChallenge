package bjoern.kinberger.evenlydevchallenge.build_logic.convention.config

import bjoern.kinberger.evenlydevchallenge.build_logic.convention.ext.androidTestImplementation
import bjoern.kinberger.evenlydevchallenge.build_logic.convention.ext.debugImplementation
import bjoern.kinberger.evenlydevchallenge.build_logic.convention.ext.implementation
import bjoern.kinberger.evenlydevchallenge.build_logic.convention.ext.libs
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
            buildConfig = true
        }

        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()
            implementation(platform(bom))
            androidTestImplementation(platform(bom))

            implementation(libs.findLibrary("androidx-activity-compose").get())
            implementation(libs.findLibrary("androidx-ui").get())
            implementation(libs.findLibrary("androidx-ui-graphics").get())
            implementation(libs.findLibrary("androidx-ui-tooling-preview").get())
            implementation(libs.findLibrary("androidx-material3").get())
            implementation(libs.findLibrary("androidx-navigation-compose").get())

            debugImplementation(libs.findLibrary("androidx-ui-tooling").get())
            debugImplementation(libs.findLibrary("androidx-ui-test-manifest").get())

            androidTestImplementation(libs.findLibrary("androidx-ui-test-junit4").get())
        }
    }
}