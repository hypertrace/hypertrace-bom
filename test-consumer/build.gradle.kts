plugins {
  `java-library`
}

dependencies {
  api(platform(projects.hypertraceBom))
  api(libs.hypertrace.grpcutils.context)
  api(libs.hypertrace.grpcutils.client)
  api(libs.hypertrace.grpcutils.server)
  api(libs.hypertrace.grpcutils.rx.client)
  api(libs.hypertrace.grpcutils.rx.server)
  api(libs.hypertrace.framework.grpc)
  api(libs.hypertrace.framework.http)
  api(libs.hypertrace.framework.spi)
  api(libs.hypertrace.kafka.framework)
  api(libs.hypertrace.integrationtest.framework)
  api(libs.hypertrace.framework.documentstore.metrics)
  api(libs.hypertrace.documentstore)
  api(libs.hypertrace.eventstore)
  api(libs.hypertrace.attributeservice.api)
  api(libs.hypertrace.attributeservice.cachingclient)
  api(libs.hypertrace.entityservice.types.rxclient)
  api(libs.hypertrace.configservice.spaces.api)
  api(libs.hypertrace.configservice.labels.api)
  api(libs.hypertrace.configservice.labelapplication.api)
  api(libs.hypertrace.configservice.spanprocessing.api)
  api(libs.hypertrace.gatewayservice.api)

  api(libs.guava)
  api(libs.rholder.guava.retrying)
  api(libs.gson)
  api(libs.google.re2j)
  api(libs.guice7)
  api(libs.guice.servlet)
  api(libs.typesafe.config)
  api(libs.lombok)
  api(libs.protobuf.java)
  api(libs.protobuf.javautil)
  api(libs.jackson.databind)
  api(libs.jackson.datatype.jdk8)
  api(libs.jackson.datatype.jsr310)
  api(libs.grpc.core)
  api(libs.grpc.stub)
  api(libs.grpc.protobuf)
  api(libs.grpc.api)
  api(libs.grpc.context)
  api(libs.grpc.inprocess)
  api(libs.grpc.netty)
  api(libs.grpc.services)
  api(libs.slf4j2.api)
  api(libs.log4j.slf4j2.impl)
  api(libs.javax.annotation)
  api(libs.rxjava3)
  api(libs.uuidcreator)
  api(libs.kafka.clients)
  api(libs.commons.lang)
  api(libs.commons.text)
  api(libs.graphql.java)
  api(libs.jsr305)
  api(libs.hypertrace.framework.grpc.jakarta)
  api(libs.hypertrace.framework.http.jakarta)
  api(libs.hypertrace.framework.spi.jakarta)
  api(libs.hypertrace.integrationtest.framework.jakarta)
  api(libs.hypertrace.framework.documentstore.metrics.jakarta)
  api(libs.apache.httpcomponents.httpclient)
  api(libs.awaitility)
  api(libs.jakarta.inject.api)
  api(libs.jakarta.servlet.api)
  api(libs.jetty.server)
  api(libs.jetty.servlet)
  api(libs.jetty.servlets)
}

tasks.register("verifyResolution") {
  doLast {
    configurations.runtimeClasspath {
      resolve()
    }
  }
}

tasks.check {
  dependsOn("verifyResolution")
}


// Handle lz4-java redirect capability conflict:
// Sonatype added a redirect from org.lz4:lz4-java:1.8.1 -> at.yawk.lz4:lz4-java:1.8.1 to address CVE-2025-12183.
// Both artifacts declare the same capability, causing a conflict when upgrading from Kafka's org.lz4:lz4-java:1.8.0.
// This resolution strategy tells Gradle to automatically select the highest version when this conflict occurs.
configurations.all {
  resolutionStrategy.capabilitiesResolution.withCapability("org.lz4:lz4-java") {
    select("at.yawk.lz4:lz4-java:1.8.1")
    because("Both org.lz4 and at.yawk.lz4 provide lz4-java due to Sonatype redirect")
  }
}
