plugins {
  `version-catalog`
  alias(libs.plugins.hypertrace.publish)
}

publishing {
  publications {
    create<MavenPublication>("maven") {
      from(components["versionCatalog"])
    }
  }
}

catalog {
  versionCatalog {
    from(rootProject.files("gradle/libs.versions.toml"))
  }
}
