import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.gradle.plugin-publish") version "0.10.1"
    `kotlin-dsl`
    `maven-publish`
}

group = "dev.dcas"
version = "0.1"

gradlePlugin {
    plugins {
        register("gradle-util-plugin") {
            id = "gradle-util-plugin"
            implementationClass = "dev.dcas.gradle.GradleExtensions"
        }
    }
}

repositories {
    maven(url = "https://mvn.v2.dcas.dev")
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    withType<KotlinCompile>().all {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
}