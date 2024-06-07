rootProject.name = "utils"

dependencyResolutionManagement {
  versionCatalogs {
    create("libs") {
      from(files("./libs.version.toml"))
    }
  }
}


plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}



include(":utils-io")
include(":utils-io-okio")
include(":utils-gson")
include(":utils-cli")

project(":utils-io").projectDir = File(rootDir, "utils-io/utils-io")
project(":utils-io-okio").projectDir = File(rootDir, "utils-io/utils-io-okio")