## org-wdt-utils

[![](https://jitpack.io/v/wd-t/utils.svg)](https://jitpack.io/#wd-t/utils)

- [utils-gson](utils-gson/README.md)
- [utils-io](utils-io/README.md)

### 用于

- [Wdtc](https://github.com/wdtve/Wdtc)
- [IntelliJManager](https://github.com/wdtve/IntelliJManager)

### 使用方法

```text
// build.gradle.kts
repositories {
	maven { url = uri("https://jitpack.io") }
	mavenLocal()
	mavenCentral()
}

dependencies {
	implementation("com.github.wdtve.utils:utils-gson:$latest_version")
	implementation("com.github.wdtve.utils:utils-io:$latest_version")
}
```