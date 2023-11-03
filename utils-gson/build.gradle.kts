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

publishing {
    publications {
        create<MavenPublication>("maven") {
            pom {
                name = "utils-gson"
                url = "https://github.com/Wd-t/org-wdt-utils"
                groupId = "org.wdt.utils.gson"
                artifactId = "utils-gson"
                version = project.version.toString()
                developers {
                    developer {
                        id = "Wdt~"
                        name = "Wdt~"
                        email = "yuwenshuxue1@outlook.com"
                    }
                }
                from(components["kotlin"])
            }
        }
    }
}




tasks.test {
    useJUnitPlatform()
}
