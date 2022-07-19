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
import io.matthewnelson.kotlin.components.dependencies.deps
import io.matthewnelson.kotlin.components.dependencies.versions
import io.matthewnelson.kotlin.components.kmp.KmpTarget

plugins {
    id(pluginId.kmp.configuration)
    id(pluginId.kmp.publish)
}

kmpConfiguration {
    setupMultiplatform(targets =
        setOf(
            KmpTarget.Jvm.Android(
                buildTools = versions.android.buildTools,
                compileSdk = versions.android.sdkCompile,
                minSdk = versions.android.sdkMin16,
                compileSourceOption = JavaVersion.VERSION_1_8,
                compileTargetOption = JavaVersion.VERSION_1_8,
                kotlinJvmTarget = JavaVersion.VERSION_1_8,
                target = {
                    publishLibraryVariants("release")
                },
                mainSourceSet = {
                    dependencies {
                        compileOnly(deps.kotlin.parcelize.runtime)
                    }
                }
            ),

            KmpTarget.Jvm.Jvm(kotlinJvmTarget = JavaVersion.VERSION_1_8),
            KmpTarget.NonJvm.JS.DEFAULT,
        ) +
        KmpTarget.NonJvm.Native.Unix.Darwin.Ios.ALL_DEFAULT     +
        KmpTarget.NonJvm.Native.Unix.Darwin.Macos.ALL_DEFAULT   +
        KmpTarget.NonJvm.Native.Unix.Darwin.Tvos.ALL_DEFAULT    +
        KmpTarget.NonJvm.Native.Unix.Darwin.Watchos.ALL_DEFAULT +
        KmpTarget.NonJvm.Native.Unix.Linux.ALL_DEFAULT          +
        KmpTarget.NonJvm.Native.Mingw.ALL_DEFAULT,

        commonMainSourceSet = {

        }
    )
}

kmpPublish {
    setupModule(
        pomDescription = "Enables usage of android Parcelable from kotlin multiplatform common code",
    )
}
