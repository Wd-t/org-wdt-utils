plugins {
    kotlin("jvm")
}

group = "org.wdt.utils.gson"
version = rootProject.version

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
    implementation(project(":utils-io"))
    testImplementation(kotlin("test"))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            pom {
                name = "utils-gson"
                url = "https://github.com/wd-t/utils"
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
