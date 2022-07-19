/*
 * Copyright (c) 2022 Matthew Nelson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    dependencies {
        classpath(io.matthewnelson.kotlin.components.dependencies.plugins.android.gradle)
        classpath(io.matthewnelson.kotlin.components.dependencies.plugins.kotlin.gradle)
        classpath(io.matthewnelson.kotlin.components.dependencies.plugins.mavenPublish)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

plugins {
    id(pluginId.kmp.publish)
}

kmpPublish {
    setupRootProject(
        versionName = "0.1.0-SNAPSHOT",
        // 1.0.0-alpha1 == 01_00_00_11
        // 1.0.0-alpha2 == 01_00_00_12
        // 1.0.0-beta1  == 01_00_00_21
        // 1.0.0-rc1    == 01_00_00_31
        // 1.0.0        == 01_00_00_99
        // 1.0.1        == 01_00_01_99
        // 1.1.1        == 01_01_01_99
        // 1.15.1       == 01_15_01_99
        versionCode = /*00_0 */1_00_99,
        pomInceptionYear = 2022,
    )
}
