plugins {
    kotlin("jvm") version "1.9.0"
}

group = "org.wdt.utils.io"
version = rootProject.version
dependencies {
    testImplementation(kotlin("test"))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            pom {
                name = "utils-io"
                url = "https://github.com/Wd-t/org-wdt-utils"
                groupId = "org.wdt.utils.io"
                artifactId = "utils-io"
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
