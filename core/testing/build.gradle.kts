plugins {
    id("todoapp.android.library")
    id("todoapp.android.hilt")
}

android {
    namespace = "com.joblogic.todoapp.core.testing"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:data"))

    // Coroutines
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.test)

    // Test runner
    implementation(libs.androidx.test.runner)

    // Hilt test
    implementation(libs.com.google.dagger.hilt.android.testing)

    // Local unit tests
    implementation(libs.junit)
}