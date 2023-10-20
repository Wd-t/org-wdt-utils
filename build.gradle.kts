subprojects {
    repositories {
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://maven.aliyun.com/repository/public/") }
        mavenLocal()
        mavenCentral()
    }
    apply {
        plugin("idea")
        plugin("java")
        plugin("application")
        plugin("maven-publish")
    }
}

version = "1.1.0"