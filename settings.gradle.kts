pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "To Do App"
include(":app")
include(":core:model")
include(":core:designsystem")
include(":core:common")
include(":core:network")
include(":core:data")
include(":core:domain")
include(":feature:call")
include(":feature:buy")
include(":core:database")
include(":core:testing")
