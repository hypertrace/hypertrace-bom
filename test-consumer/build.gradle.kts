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
  api(libs.grpc.stub)
  api(libs.grpc.protobuf)
  api(libs.grpc.api)
  api(libs.grpc.netty)
  api(libs.slf4j2.api)
  api(libs.log4j.slf4j2.impl)
  api(libs.javax.annotation)
  api(libs.rxjava3)
  api(libs.uuidcreator)
}
