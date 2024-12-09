import bjoern.kinberger.evenlydevchallenge.build_logic.convention.config.configureAndroidCompose
import bjoern.kinberger.evenlydevchallenge.build_logic.convention.config.configureKotlinAndroid
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.compose")
                apply("bjoern.kinberger.evenlydevchallenge.koin")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                configureAndroidCompose(this)
                defaultConfig.applicationId = "bjoern.kinberger.evenlydevchallenge"
                defaultConfig.targetSdk = 34
                defaultConfig.versionCode = 1
                defaultConfig.versionName = "1.0"
            }
        }
    }
}