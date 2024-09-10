enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        maven {
            url = uri("https://inexus.samentic.com/repository/samentic-android/")
            artifactUrls("https://inexus.samentic.com/repository/samentic-android/")
            credentials {
                username = "piremard"
                password = "KAR@2013dorost"
            }
        }
        /*google()
        gradlePluginPortal()
        mavenCentral()*/
    }
}

dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://inexus.samentic.com/repository/samentic-android/")
            artifactUrls("https://inexus.samentic.com/repository/samentic-android/")
            credentials {
                username = "piremard"
                password = "KAR@2013dorost"
            }
        }
        //google()
        //mavenCentral()
    }
}

rootProject.name = "WindSpeed"
include(":androidApp")
include(":shared")