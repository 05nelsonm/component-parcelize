# component-parcelize
[![badge-license]][url-license]
[![badge-latest-release]][url-latest-release]

[![badge-kotlin]][url-kotlin]

![badge-platform-android]
![badge-platform-jvm]
![badge-platform-js]
![badge-platform-js-node]
![badge-platform-linux]
![badge-platform-macos]
![badge-platform-ios]
![badge-platform-tvos]
![badge-platform-watchos]
![badge-platform-wasm]
![badge-platform-windows]
![badge-support-android-native]
![badge-support-apple-silicon]
![badge-support-js-ir]

Kotlin Multiplatform support for using `android.os.Parcelable` from common code.

A full list of `kotlin-components` projects can be found [HERE](https://kotlin-components.matthewnelson.io)

### Get Started

<!-- TAG_VERSION -->

 - Add dependency to `commonMain`
   ```kotlin
   // build.gradle.kts
   dependencies {
       val vParcelize = "0.1.2"
       // If usage is a part of your public api, use `api`; otherwise
       // use `implementation` for internal-only usage.
       api("io.matthewnelson.kotlin-components:parcelize:$vParcelize")
   }
   ```

   ```groovy
   // build.gradle
   dependencies {
       def vParcelize = "0.1.1"
       // If usage is a part of your public api, use `api`; otherwise
       // use `implementation` for internal-only usage.
       api "io.matthewnelson.kotlin-components:parcelize:$vParcelize"
   }
   ```

 - Add the `kotlin-parcelize` plugin to your project
   ```kotlin
   plugins {
       id("kotlin-parcelize")
   }
   ```

### Usage

 - In `commonMain`
   ```kotlin
   import io.matthewnelson.component.parcelize.Parcelable
   import io.matthewnelson.component.parcelize.Parcelize

   @Parcelize
   data class MyData(val value: String): Parcelable
   ```
 - Usable from `androidMain`
   ```kotlin
   // androidMain
   val intent = Intent()
   intent.putExtra("MY_DATA", MyData("Parcelable commonMain class"))
   
   val myData = intent.getParcelableExtra<MyData>("MY_DATA")
   println(myData.toString())
   ```

 - See the [sample-data][url-sample-data] and [sample-app][url-sample-app] examples

### Kotlin Version Compatibility

<!-- TAG_VERSION -->

| parcelize | kotlin |
|:---------:|:------:|
|   0.1.2   | 1.8.0  |
|   0.1.1   | 1.7.20 |
|   0.1.0   | 1.6.21 |

### Git

This project utilizes git submodules. You will need to initialize them when
cloning the repository via:

```bash
$ git clone --recursive https://github.com/05nelsonm/component-parcelize.git
```

If you've already cloned the repository, run:
```bash
$ git checkout master
$ git pull
$ git submodule update --init
```

In order to keep submodules updated when pulling the latest code, run:
```bash
$ git pull --recurse-submodules
```

<!-- TAG_VERSION -->
[badge-latest-release]: https://img.shields.io/badge/latest--release-0.1.2-blue.svg?style=flat
[badge-license]: https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat

<!-- TAG_DEPENDENCIES -->
[badge-kotlin]: https://img.shields.io/badge/kotlin-1.8.0-blue.svg?logo=kotlin

<!-- TAG_PLATFORMS -->
[badge-platform-android]: http://img.shields.io/badge/-android-6EDB8D.svg?style=flat
[badge-platform-jvm]: http://img.shields.io/badge/-jvm-DB413D.svg?style=flat
[badge-platform-js]: http://img.shields.io/badge/-js-F8DB5D.svg?style=flat
[badge-platform-js-node]: https://img.shields.io/badge/-nodejs-68a063.svg?style=flat
[badge-platform-linux]: http://img.shields.io/badge/-linux-2D3F6C.svg?style=flat
[badge-platform-macos]: http://img.shields.io/badge/-macos-111111.svg?style=flat
[badge-platform-ios]: http://img.shields.io/badge/-ios-CDCDCD.svg?style=flat
[badge-platform-tvos]: http://img.shields.io/badge/-tvos-808080.svg?style=flat
[badge-platform-watchos]: http://img.shields.io/badge/-watchos-C0C0C0.svg?style=flat
[badge-platform-wasm]: https://img.shields.io/badge/-wasm-624FE8.svg?style=flat
[badge-platform-windows]: http://img.shields.io/badge/-windows-4D76CD.svg?style=flat
[badge-support-android-native]: http://img.shields.io/badge/support-[AndroidNative]-6EDB8D.svg?style=flat
[badge-support-apple-silicon]: http://img.shields.io/badge/support-[AppleSilicon]-43BBFF.svg?style=flat
[badge-support-js-ir]: https://img.shields.io/badge/support-[js--IR]-AAC4E0.svg?style=flat

[url-latest-release]: https://github.com/05nelsonm/component-parcelize/releases/latest
[url-license]: https://www.apache.org/licenses/LICENSE-2.0.txt
[url-kotlin]: https://kotlinlang.org
[url-sample-app]: https://github.com/05nelsonm/component-parcelize/tree/master/sample/app
[url-sample-data]: https://github.com/05nelsonm/component-parcelize/tree/master/sample/sample-data
