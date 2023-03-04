plugins {
    id("todoapp.android.library")
    id("todoapp.android.hilt")
}

android {
    namespace = "com.joblogic.todoapp.core.data"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:network"))
    implementation(project(":core:database"))

    // Hilt Test
    implementation(libs.com.google.dagger.hilt.android.testing)

    testImplementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.test)
}