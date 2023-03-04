plugins {
    id("todoapp.android.application")
    id("todoapp.android.application.compose")
    id("todoapp.android.hilt")
}

android {
    defaultConfig {
        applicationId = "com.joblogic.todoapp"
        versionCode = 1
        versionName = "0.0.1" // X.Y.Z; X = Major, Y = minor, Z = Patch level

        // Custom test runner to set up Hilt dependency graph
        testInstrumentationRunner = "com.joblogic.todoapp.core.testing.ToDoAppTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        val release by getting {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
        // TODO: Convert it as a convention plugin once Flamingo goes out (https://github.com/android/todoapp/issues/523)
        managedDevices {
            devices {
                maybeCreate<com.android.build.api.dsl.ManagedVirtualDevice>("pixel4api30").apply {
                    device = "Pixel 4"
                    apiLevel = 30
                    // ATDs currently support only API level 30.
                    systemImageSource = "aosp-atd"
                }
            }
        }
    }
    namespace = "com.joblogic.todoapp"
}

dependencies {
    implementation(project(":feature:call"))
    implementation(project(":feature:buy"))

    implementation(project(":core:common"))
    implementation(project(":core:designsystem"))

    // Dagger Hilt
    implementation(libs.androidx.hilt.hilt.navigation.compose)

    // Lifecycle
    implementation(libs.androidx.lifecycle.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.lifecycle.viewmodel.compose)

    // Navigation
    implementation(libs.androidx.navigation.navigation.compose)

    // Splash screen
    implementation(libs.androidx.core.core.splashscreen)

    // Utils
    implementation(libs.androidx.tracing.tracing.ktx)
}