import org.hypertrace.gradle.publishing.HypertracePublishExtension
import org.hypertrace.gradle.publishing.License

plugins {
  alias(libs.plugins.hypertrace.repository)
  alias(libs.plugins.hypertrace.ciutils)
  alias(libs.plugins.hypertrace.publish) apply false
  alias(libs.plugins.hypertrace.codestyle) apply false
  alias(libs.plugins.owasp.dependencycheck)
}

subprojects {
  group = "org.hypertrace.bom"

  apply(plugin = rootProject.libs.plugins.hypertrace.codestyle.get().pluginId)

  pluginManager.withPlugin(rootProject.libs.plugins.hypertrace.publish.get().pluginId) {
    configure<HypertracePublishExtension> {
      license.set(License.TRACEABLE_COMMUNITY)
    }
  }
}

dependencyCheck {
  format = org.owasp.dependencycheck.reporting.ReportGenerator.Format.ALL.toString()
  suppressionFile = "owasp-suppressions.xml"
  scanConfigurations.add("runtimeClasspath")
  failBuildOnCVSS = 3.0F
}
