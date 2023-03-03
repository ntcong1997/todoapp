plugins {
    id("todoapp.android.library")
    kotlin("kapt")
}

android {
    namespace = "com.joblogic.todoapp.core.domain"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    // Coroutines
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)

    implementation(libs.com.google.dagger.hilt.android)
    kapt(libs.com.google.dagger.hilt.android.compiler)
}