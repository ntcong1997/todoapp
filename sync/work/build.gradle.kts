plugins {
    id("todoapp.android.library")
    id("todoapp.android.hilt")
}

android {
    defaultConfig {
        testInstrumentationRunner = "com.joblogic.todoapp.core.testing.ToDoAppTestRunner"
    }
    namespace = "com.joblogic.todoapp.sync.work"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":core:data"))

    androidTestImplementation(project(":core:testing"))

    implementation(libs.androidx.test.core)

    // Coroutines
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)

    // Startup
    implementation(libs.androidx.startup.startup.runtime)

    // Hilt
    implementation(libs.androidx.hilt.hilt.work)
    kapt(libs.androidx.hilt.hilt.compiler)
    androidTestImplementation(libs.com.google.dagger.hilt.android.testing)

    // Work manager
    implementation(libs.androidx.work.work.runtime.ktx)
    androidTestImplementation(libs.androidx.work.work.testing)
}