plugins {
    kotlin("jvm") version "1.9.0"
}

group = "org.wdt.utils.io"

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
