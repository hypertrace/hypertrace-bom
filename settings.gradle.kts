rootProject.name = "hypertrace-bom-root"

pluginManagement {
  repositories {
    mavenLocal()
    gradlePluginPortal()
    maven("https://us-maven.pkg.dev/hypertrace-repos/maven")
  }
}

plugins {
  id("org.hypertrace.version-settings") version "0.3.0"
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":hypertrace-bom")
include(":hypertrace-version-catalog")
include(":test-consumer")
