import bjoern.kinberger.evenlydevchallenge.build_logic.convention.ext.implementation
import bjoern.kinberger.evenlydevchallenge.build_logic.convention.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KoinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
            }

            dependencies {
                val bom = libs.findLibrary("koin-bom").get()
                implementation(platform(bom))
                implementation(libs.findBundle("koin").get())
                "ksp"(libs.findLibrary("koin-compiler").get())
            }
        }
    }
}