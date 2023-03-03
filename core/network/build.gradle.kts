plugins {
    id("todoapp.android.library")
    id("todoapp.android.hilt")
    id("kotlinx-serialization")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    buildFeatures {
        buildConfig = true
    }

    namespace = "com.joblogic.todoapp.core.network"

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

secrets {
    defaultPropertiesFileName = "secrets.defaults.properties"
}

dependencies {
    implementation(project(":core:common"))

    // Coroutines
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)
    testImplementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.test)

    // Hilt Test
    implementation(libs.com.google.dagger.hilt.android.testing)

    // Retrofit & Okhttp
    implementation(libs.com.squareup.retrofit2.retrofit)
    implementation(libs.com.jakewharton.retrofit.retrofit2.kotlinx.serialization.converter)
    implementation(libs.com.squareup.okhttp3.logging.interceptor)

    // Json
    implementation(libs.org.jetbrains.kotlinx.kotlinx.serialization.json)
}