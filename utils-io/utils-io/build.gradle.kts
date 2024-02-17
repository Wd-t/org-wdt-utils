plugins {
    alias(libs.plugins.kotlin)
}

group = "org.wdt.utils.io"
version = rootProject.version

dependencies {
    implementation(libs.stdlib.jdk8)
    testImplementation(libs.stdlib.test)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            pom {
                name = "utils-io"
                url = "https://github.com/wd-t/utils"
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
