plugins {
    id("todoapp.android.library")
    id("todoapp.android.hilt")
}

android {
    namespace = "com.joblogic.todoapp.core.common"
}

dependencies {
    // Coroutines
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)
    testImplementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.test)

    // Turbine
    testImplementation(libs.app.cash.turbine)
}