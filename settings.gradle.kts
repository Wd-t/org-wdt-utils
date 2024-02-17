rootProject.name = "utils"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("./libs.version.toml"))
        }
    }
}


include(":utils-io")
include(":utils-io-okio")
include(":utils-gson")
include(":utils-cli")

project(":utils-io").projectDir = File(rootDir, "utils-io/utils-io")
project(":utils-io-okio").projectDir = File(rootDir, "utils-io/utils-io-okio")