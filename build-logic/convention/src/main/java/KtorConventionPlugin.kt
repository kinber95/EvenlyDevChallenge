import bjoern.kinberger.evenlydevchallenge.build_logic.convention.ext.implementation
import bjoern.kinberger.evenlydevchallenge.build_logic.convention.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KtorConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                implementation(libs.findBundle("ktor").get())
            }
        }
    }
}