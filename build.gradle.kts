/*
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

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
            id = "dev.dcas.gradle-util"
            implementationClass = "dev.dcas.gradle.GradleExtensions"
            displayName = "Gradle Util Plugin"
            description = "Small utilities to making your Gradle-Kotlin life easier."
        }
    }
}

pluginBundle {
    website = "https://github.com/djcass44/gradle-util-plugin"
    vcsUrl = "https://github.com/djcass44/gradle-util-plugin"
    tags = listOf("kotlin-dsl", "kotlin-extensions")
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