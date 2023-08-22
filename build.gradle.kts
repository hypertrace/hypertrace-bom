import org.hypertrace.gradle.publishing.HypertracePublishExtension
import org.hypertrace.gradle.publishing.License

plugins {
  id("org.hypertrace.repository-plugin") version "0.4.2"
  id("org.hypertrace.ci-utils-plugin") version "0.3.2"
  id("org.hypertrace.publish-plugin") version "1.0.5" apply false
  id("org.hypertrace.code-style-plugin") version "1.2.0" apply false
  id("org.owasp.dependencycheck") version "8.4.0"
}

subprojects {
  group = "org.hypertrace.bom"
  apply(plugin = "org.hypertrace.code-style-plugin")

  pluginManager.withPlugin("org.hypertrace.publish-plugin") {
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
