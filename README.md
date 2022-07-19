# component-parcelize
[![badge-license]][url-license]
[![badge-latest-release]][url-latest-release]

[![badge-kotlin]][url-kotlin]

![badge-platform-android]
![badge-platform-jvm]
![badge-platform-apple-silicon]
![badge-platform-ios]
![badge-platform-js]
![badge-platform-node-js]
![badge-platform-linux]
![badge-platform-macos]
![badge-platform-tvos]
![badge-platform-watchos]
![badge-platform-windows]

Kotlin Multiplatform support for using `android.os.Parcelable` from common code.

A full list of `kotlin-components` projects can be found [HERE](https://kotlin-components.matthewnelson.io)

### Get Started

<!-- TAG_VERSION -->
 - Add dependency to `commonMain`
   ```kotlin
   // build.gradle.kts
   dependencies {
       val vParcelize = "0.1.0"
       // If usage is a part of your public api, use `api`; otherwise
       // use `implementation` for internal-only usage.
       api("io.matthewnelson.kotlin-components:parcelize:$vParcelize")
   }
   ```

   ```groovy
   // build.gradle
   dependencies {
       def vParcelize = "0.1.0"
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

<!-- TAG_DEPENDENCIES -->
| parcelize  |   kotlin   |
|:----------:|:----------:|
|   0.1.0    |   1.6.21   |

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
[badge-latest-release]: https://img.shields.io/badge/latest--release-0.1.0-blue.svg?style=flat
[badge-license]: https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat

<!-- TAG_DEPENDENCIES -->
[badge-kotlin]: https://img.shields.io/badge/kotlin-1.6.21-blue.svg?logo=kotlin

<!-- TAG_PLATFORMS -->
[badge-platform-android]: https://camo.githubusercontent.com/b1d9ad56ab51c4ad1417e9a5ad2a8fe63bcc4755e584ec7defef83755c23f923/687474703a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d616e64726f69642d3645444238442e7376673f7374796c653d666c6174
[badge-platform-apple-silicon]: https://camo.githubusercontent.com/a92c841ffd377756a144d5723ff04ecec886953d40ac03baa738590514714921/687474703a2f2f696d672e736869656c64732e696f2f62616467652f737570706f72742d2535424170706c6553696c69636f6e2535442d3433424246462e7376673f7374796c653d666c6174
[badge-platform-ios]: https://camo.githubusercontent.com/1fec6f0d044c5e1d73656bfceed9a78fd4121b17e82a2705d2a47f6fd1f0e3e5/687474703a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d696f732d4344434443442e7376673f7374796c653d666c6174
[badge-platform-jvm]: https://camo.githubusercontent.com/700f5dcd442fd835875568c038ae5cd53518c80ae5a0cf12c7c5cf4743b5225b/687474703a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d6a766d2d4442343133442e7376673f7374796c653d666c6174
[badge-platform-js]: https://camo.githubusercontent.com/3e0a143e39915184b54b60a2ecedec75e801f396d34b5b366c94ec3604f7e6bd/687474703a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d6a732d4638444235442e7376673f7374796c653d666c6174
[badge-platform-node-js]: https://camo.githubusercontent.com/d08fda729ceebcae0f23c83499ca8f06105350f037661ac9a4cc7f58edfdbca9/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d6e6f64656a732d3638613036332e7376673f7374796c653d666c6174
[badge-platform-linux]: https://camo.githubusercontent.com/a2c518ecf30b2c88dd6af8bbc5281b6014686b916368e6197ef2a5e1dda7adb4/687474703a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d6c696e75782d3244334636432e7376673f7374796c653d666c6174
[badge-platform-macos]: https://camo.githubusercontent.com/1b8313498db244646b38a4480186ae2b25464e5e8d71a1920c52b2be5212b909/687474703a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d6d61636f732d3131313131312e7376673f7374796c653d666c6174
[badge-platform-tvos]: https://camo.githubusercontent.com/4ac08d7fb1bcb8ef26388cd2bf53b49626e1ab7cbda581162a946dd43e6a2726/687474703a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d74766f732d3830383038302e7376673f7374796c653d666c6174
[badge-platform-watchos]: https://camo.githubusercontent.com/135dbadae40f9cabe7a3a040f9380fb485cff36c90909f3c1ae36b81c304426b/687474703a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d77617463686f732d4330433043302e7376673f7374796c653d666c6174
[badge-platform-windows]: https://camo.githubusercontent.com/01bd13daf3ea3068952f50840e3f36a305803cc248af08f084cb9e37df78123d/687474703a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d77696e646f77732d3444373643442e7376673f7374796c653d666c6174

[url-latest-release]: https://github.com/05nelsonm/component-parcelize/releases/latest
[url-license]: https://www.apache.org/licenses/LICENSE-2.0
[url-kotlin]: https://kotlinlang.org
[url-sample-app]: https://github.com/05nelsonm/component-parcelize/tree/master/sample/app
[url-sample-data]: https://github.com/05nelsonm/component-parcelize/tree/master/sample/sample-data
