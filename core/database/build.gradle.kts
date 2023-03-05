plugins {
    id("todoapp.android.library")
    id("todoapp.android.hilt")
    id("todoapp.android.room")
}

android {
    defaultConfig {
        testInstrumentationRunner =
            "com.joblogic.todoapp.core.testing.ToDoAppTestRunner"
    }
    namespace = "com.joblogic.todoapp.core.database"
}

dependencies {
    androidTestImplementation(project(":core:testing"))

    androidTestImplementation(libs.androidx.test.core)

    // Coroutines
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)
    androidTestImplementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.test)
}
