rootProject.name = "component-parcelize"

includeBuild("kotlin-components/includeBuild/dependencies")
includeBuild("kotlin-components/includeBuild/kmp")

@Suppress("PrivatePropertyName")
private val KMP_TARGETS: String? by settings
@Suppress("PrivatePropertyName")
private val CHECK_PUBLICATION: String? by settings
@Suppress("PrivatePropertyName")
private val KMP_TARGETS_ALL = System.getProperty("KMP_TARGETS_ALL") != null
@Suppress("PrivatePropertyName")
private val TARGETS = KMP_TARGETS?.split(',')

if (CHECK_PUBLICATION != null) {
    include(":tools:check-publication")
} else {
    include(":parcelize")
    include(":sample:sample-data")

    if (KMP_TARGETS_ALL || TARGETS?.contains("ANDROID") != false) {
        include(":sample:app")
    }
}
