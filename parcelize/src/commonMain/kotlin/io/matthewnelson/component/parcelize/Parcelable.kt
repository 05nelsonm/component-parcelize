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
package io.matthewnelson.component.parcelize

/**
 * Interface that is typealias to `android.os.Parcelable` on
 * android sources to enable use of the `kotlin-parcelize` plugin from
 * commonMain.
 *
 * This does nothing when used in multiplatform projects that do not
 * contain an android target.
 * */
expect interface Parcelable
