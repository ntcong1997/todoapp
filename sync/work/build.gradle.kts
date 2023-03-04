plugins {
    id("todoapp.android.library")
    id("todoapp.android.hilt")
}

android {
    defaultConfig {
        testInstrumentationRunner = "com.joblogic.todoapp.core.testing.TodoAppTestRunner"
    }
    namespace = "com.joblogic.todoapp.sync.work"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":core:data"))

    // Coroutines
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)

    // Startup
    implementation(libs.androidx.startup.startup.runtime)

    // Work manager
    implementation(libs.androidx.work.work.runtime.ktx)
    implementation(libs.androidx.hilt.hilt.work)
    kapt(libs.androidx.hilt.hilt.compiler)
}