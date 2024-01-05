plugins {
    kotlin("jvm") version "1.9.21" apply false
}

subprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    apply {
        plugin("java")
        plugin("application")
        plugin("maven-publish")
    }
}
group = "org.wdt.utils"
version = "1.3.1"