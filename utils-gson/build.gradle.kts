plugins {
  alias(libs.plugins.kotlin)
}

group = "org.wdt.utils.gson"
version = rootProject.version

dependencies {
  implementation(project(":utils-io"))
  implementation(libs.gson)
  implementation(libs.stdlib.jdk8)
  testImplementation(libs.stdlib.test)
}

publishing {
  publications {
    create<MavenPublication>("maven") {
      pom {
        name = "utils-gson"
        url = "https://github.com/wdtve/utils"
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
