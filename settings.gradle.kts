rootProject.name = "hypertrace-bom-root"

pluginManagement {
  repositories {
    mavenLocal()
    gradlePluginPortal()
    maven("https://hypertrace.jfrog.io/artifactory/maven")
  }
}

plugins {
  id("org.hypertrace.version-settings") version "0.2.1"
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":hypertrace-bom")
include(":hypertrace-version-catalog")
include(":test-consumer")
