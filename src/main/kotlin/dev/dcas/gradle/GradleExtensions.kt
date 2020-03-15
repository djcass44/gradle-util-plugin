/*
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package dev.dcas.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler

class GradleExtensions: Plugin<Project> {
    override fun apply(target: Project) {
        // this plugin does nothing
    }
}

/**
 * Builds the dependency notation for the named Spring Boot [module] at the given [version].
 *
 * @param module simple name of the Kotlin module, for example "reflect".
 * @param version optional desired version, unspecified if null.
 */
fun DependencyHandler.boot(module: String, version: String? = null): Any = "org.springframework.boot:spring-boot-$module${version?.let { ":$version" } ?: ""}"

/**
 * Builds the dependency notation for the named Spring Cloud [module] at the given [version].
 *
 * @param module simple name of the Kotlin module, for example "reflect".
 * @param version optional desired version, unspecified if null.
 */
fun DependencyHandler.cloud(module: String, version: String? = null): Any = "org.springframework.cloud:spring-cloud-$module${version?.let { ":$version" } ?: ""}"

/**
 * Builds the dependency notation for the named KotlinX [module] at the given [version].
 *
 * @param module simple name of the Kotlin module, for example "reflect".
 * @param version optional desired version, unspecified if null.
 */
fun DependencyHandler.kotlinx(module: String, version: String? = null): Any = "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" } ?: ""}"