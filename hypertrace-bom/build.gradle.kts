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
  constraints {
    api(libs.hypertrace.grpcutils.context)
    api(libs.hypertrace.grpcutils.client)
    api(libs.hypertrace.grpcutils.rx.client)
    api(libs.hypertrace.framework.grpc)
    api(libs.hypertrace.framework.http)
    api(libs.hypertrace.framework.spi)
    api(libs.hypertrace.integrationtest.framework)
    api(libs.hypertrace.documentstore)
    api(libs.hypertrace.eventstore)

    api(libs.guava)
    api(libs.typesafe.config)
    api(libs.lombok)
    api(libs.protobuf.java)
    api(libs.protobuf.javautil)
  }
}
