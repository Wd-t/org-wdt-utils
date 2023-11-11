## org-wdt-utils

- [utils-gson](utils-gson/README.md)
- [utils-io](utils-io/README.md)

### 用于

- [Wdtc](https://github.com/wd-t/Wdtc)
- [IntelliJManager](https://github.com/wd-t/IntelliJManager)

### 使用方法

```kotlin
// build.gradle.kts
repositories {
	maven { url = uri("https://jitpack.io") }
	mavenLocal()
	mavenCentral()
}

dependencies {
	implementation("com.github.wd-t.utils:utils-gson:1.2.2")
	implementation("com.github.wd-t.utils:utils-io:1.2.2")
}
```