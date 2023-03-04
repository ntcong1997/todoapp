plugins {
    id("todoapp.android.library")
    id("todoapp.android.hilt")
}

android {
    namespace = "com.example.todoapp.core.testing"
}

dependencies {
    // Test runner
    implementation(libs.androidx.test.runner)

    // Hilt test
    implementation(libs.com.google.dagger.hilt.android.testing)

    // Local unit tests
    implementation(libs.junit)
}