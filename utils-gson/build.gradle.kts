plugins {
    kotlin("jvm") version "1.9.0"
}

group = "org.wdt.utils.gson"
version = rootProject.version

dependencies {
    implementation(project(":utils-io"))
    implementation("com.google.code.gson:gson:2.10.1")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
