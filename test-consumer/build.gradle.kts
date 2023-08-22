plugins {
  `java-library`
}

dependencies {
  api(platform(projects.hypertraceBom))
  api(libs.hypertrace.grpcutils.context)
  api(libs.hypertrace.grpcutils.client)
  api(libs.hypertrace.grpcutils.rx.client)
  api(libs.hypertrace.framework.grpc)
  api(libs.hypertrace.framework.http)
  api(libs.hypertrace.framework.spi)
  api(libs.hypertrace.kafka.framework)
  api(libs.hypertrace.integrationtest.framework)
  api(libs.hypertrace.documentstore)
  api(libs.hypertrace.eventstore)

  api(libs.guava)
  api(libs.typesafe.config)
  api(libs.lombok)
  api(libs.protobuf.java)
  api(libs.protobuf.javautil)
  api(libs.jackson.databind)
  api(libs.grpc.core)
}
