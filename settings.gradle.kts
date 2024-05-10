pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NameLove"
include(":app")
include(":core:data")
include(":core:common")
include(":core:domain")
include(":core:designsystem")
include(":core:database")
include(":core:network")
include(":core:ui")
include(":core:datastore")
include(":feature:input")
include(":feature:result")
