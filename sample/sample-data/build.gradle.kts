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
import io.matthewnelson.kotlin.components.kmp.KmpTarget

plugins {
    id(pluginId.kmp.configuration)

    // See the `KmpTarget.Jvm.Android` setup below
}

kmpConfiguration {
    setupMultiplatform(targets =
        setOf(
            KmpTarget.Jvm.Android(
                buildTools = versions.android.buildTools,
                compileSdk = versions.android.sdkCompile,
                minSdk = versions.android.sdkMin16,
                namespace = "io.matthewnelson.component.parcelize.sample.data",

                // Add the `kotlin-parcelize` plugin
                //
                // This would typically be done up in the plugins
                // block, but b/c I'm using a custom plugin for
                // configuring kotlin multiplatform it's down here.
                pluginIds = setOf("kotlin-parcelize"),
            ),

            KmpTarget.Jvm.Jvm.DEFAULT,
            KmpTarget.NonJvm.JS.DEFAULT,
            KmpTarget.NonJvm.Native.Unix.Darwin.Watchos.DeviceArm64.DEFAULT,
        ) +
        KmpTarget.NonJvm.Native.Android.ALL_DEFAULT             +
        KmpTarget.NonJvm.Native.Unix.Darwin.Ios.ALL_DEFAULT     +
        KmpTarget.NonJvm.Native.Unix.Darwin.Macos.ALL_DEFAULT   +
        KmpTarget.NonJvm.Native.Unix.Darwin.Tvos.ALL_DEFAULT    +
        KmpTarget.NonJvm.Native.Unix.Darwin.Watchos.ALL_DEFAULT +
        KmpTarget.NonJvm.Native.Unix.Linux.ALL_DEFAULT          +
        KmpTarget.NonJvm.Native.Mingw.ALL_DEFAULT               +
        KmpTarget.NonJvm.Native.Wasm.ALL_DEFAULT,

        commonMainSourceSet = {
            dependencies {
                // If usage is a part of your public api, use `api`; otherwise
                // use `implementation` for internal-only usage.
                api(project(":parcelize"))
            }
        }
    )
}
