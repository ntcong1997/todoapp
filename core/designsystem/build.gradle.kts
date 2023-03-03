plugins {
    id("todoapp.android.library")
    id("todoapp.android.library.compose")
}

android {
    namespace = "com.joblogic.todoapp.core.designsystem"
}

dependencies {
    // Core
    implementation(libs.androidx.core.core.ktx)

    // Compose
    api(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material.material.icons.extended)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.ui.tooling)
    api(libs.androidx.compose.ui.ui.tooling.preview)
}