plugins {
    alias(libs.plugins.kotlin)
}

dependencies {
    implementation(libs.stdlib.jdk8)
    implementation(libs.okio)
    testImplementation(libs.stdlib.test)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            pom {
                name = "utils-io-okio"
                url = "https://github.com/wd-t/utils"
                groupId = "org.wdt.utils.io"
                artifactId = "utils-io-okio"
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
