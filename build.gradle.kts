subprojects {
  repositories {
    mavenCentral()
  }
  apply {
    plugin("java")
    plugin("application")
    plugin("maven-publish")
  }
}
group = "org.wdt.utils"
version = "1.3.9-RC2"