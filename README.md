# Gradle Util Plugin

This Gradle plugin provides some small utilities to making your life easier.

### Requirements

* Kotlin DSL
* Targeting Java 11 or above

### Installation

Add the following to your `build.gradle.kts`
```kotlin
plugins {
    id("dev.dcas.gradle-util") version "0.1"
}
```

## Dependencies

Before
```kotlin
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
}
```
After
```kotlin
dependencies {
    implementation(boot("starter-data-jpa"))
    implementation(cloud("starter-cloud"))
    implementation(kotlinx("coroutines-core"))
}
```