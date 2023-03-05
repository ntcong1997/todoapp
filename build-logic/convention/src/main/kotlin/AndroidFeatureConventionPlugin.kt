import com.android.build.gradle.LibraryExtension
import com.joblogic.todoapp.configureGradleManagedDevices
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("todoapp.android.library")
                apply("todoapp.android.hilt")
            }
            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner =
                        "com.joblogic.todoapp.core.testing.ToDoAppTestRunner"
                }
                configureGradleManagedDevices(this)
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                add("implementation", project(":core:model"))
                add("implementation", project(":core:designsystem"))
                add("implementation", project(":core:common"))
                add("implementation", project(":core:domain"))

                add("testImplementation", kotlin("test"))
                add("testImplementation", project(":core:testing"))
                add("testImplementation", project(":core:data"))
                add("androidTestImplementation", kotlin("test"))
                add("androidTestImplementation", project(":core:testing"))

                add("implementation", libs.findLibrary("androidx.test.core").get())
                add("implementation", libs.findLibrary("androidx.hilt.hilt.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.lifecycle.runtime.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.lifecycle.viewmodel.compose").get())

                add("implementation", libs.findLibrary("org.jetbrains.kotlinx.kotlinx.coroutines.android").get())

                add("testImplementation", libs.findLibrary("org.jetbrains.kotlinx.kotlinx.coroutines.test").get())

                add("androidTestImplementation", libs.findLibrary("androidx.compose.ui.ui.test.junit4").get())
                add("debugImplementation", libs.findLibrary("androidx.compose.ui.ui.test.manifest").get())
            }
        }
    }
}
