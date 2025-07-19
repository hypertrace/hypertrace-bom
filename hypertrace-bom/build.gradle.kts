plugins {
  `java-platform`
  alias(libs.plugins.hypertrace.publish)
}

javaPlatform {
  allowDependencies()
}

dependencies {
  api(platform(libs.grpc.bom))
  api(platform(libs.jackson.bom))
  api(platform(libs.hypertrace.kafka.bom))
  api(platform(libs.jetty.bom))
  api(platform(libs.netty.bom))
  constraints {
    api(libs.hypertrace.grpcutils.context)
    api(libs.hypertrace.grpcutils.client)
    api(libs.hypertrace.grpcutils.rx.client)
    api(libs.hypertrace.grpcutils.rx.server)
    api(libs.hypertrace.framework.grpc)
    api(libs.hypertrace.framework.http)
    api(libs.hypertrace.framework.spi)
    api(libs.hypertrace.framework.metrics)
    api(libs.hypertrace.integrationtest.framework)
    api(libs.hypertrace.documentstore)
    api(libs.hypertrace.framework.documentstore.metrics)
    api(libs.hypertrace.eventstore)
    api(libs.hypertrace.attributeservice.api)
    api(libs.hypertrace.attributeservice.cachingclient)
    api(libs.hypertrace.gatewayservice.api)
    api(libs.hypertrace.entityservice.types.rxclient)
    api(libs.hypertrace.configservice.spaces.api)
    api(libs.hypertrace.configservice.labels.api)
    api(libs.hypertrace.configservice.labelapplication.api)
    api(libs.hypertrace.configservice.spanprocessing.api)

    api(libs.guava)
    api(libs.gson)
    api(libs.google.re2j)
    api(libs.guice)
    api(libs.rholder.guava.retrying)
    api(libs.rxjava3)
    api(libs.uuidcreator)
    api(libs.typesafe.config)
    api(libs.lombok)
    api(libs.protobuf.java)
    api(libs.protobuf.javautil)
    api(libs.kafka.clients)
    api(libs.slf4j2.api)
    api(libs.log4j.slf4j2.impl)
    api(libs.commons.lang)
    api(libs.commons.text)
    api(libs.graphql.java)
    api(libs.jsr305)
  }
}
