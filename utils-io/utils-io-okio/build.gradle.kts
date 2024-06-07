import org.gradle.api.JavaVersion.VERSION_1_8

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
        url = "https://github.com/wdtve/utils"
        groupId = "org.wdt.utils.io"
        artifactId = "utils-io-okio"
        version = rootProject.version.toString()
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

java {
  targetCompatibility = VERSION_1_8
  sourceCompatibility = VERSION_1_8
}

kotlin {
  jvmToolchain(8)
}