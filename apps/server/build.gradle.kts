plugins {
  java
  id("org.springframework.boot") version "3.5.6"
  id("io.spring.dependency-management") version "1.1.7"
  id("com.netflix.dgs.codegen") version "7.0.3"
  id("org.hibernate.orm") version "6.6.29.Final"
  id("org.graalvm.buildtools.native") version "0.10.6"
  id("org.asciidoctor.jvm.convert") version "3.3.2"
}

group = "io"

version = "0.0.1-SNAPSHOT"

description = ""

java { toolchain { languageVersion = JavaLanguageVersion.of(21) } }

configurations { compileOnly { extendsFrom(configurations.annotationProcessor.get()) } }

repositories { mavenCentral() }

extra["snippetsDir"] = file("build/generated-snippets")

extra["netflixDgsVersion"] = "10.2.1"

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-batch")
  implementation("org.springframework.boot:spring-boot-starter-cache")
  implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-data-redis")
  implementation("org.springframework.boot:spring-boot-starter-jooq")
  implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
  implementation("org.springframework.boot:spring-boot-starter-quartz")
  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("org.bouncycastle:bcprov-jdk18on:1.78.1")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-websocket")
  implementation("com.netflix.graphql.dgs:graphql-dgs-spring-graphql-starter")
  implementation("org.flywaydb:flyway-core")
  implementation("org.flywaydb:flyway-mysql")
  implementation("org.springframework.session:spring-session-data-redis")
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  developmentOnly("org.springframework.boot:spring-boot-docker-compose")
  runtimeOnly("com.mysql:mysql-connector-j")
  runtimeOnly("io.micrometer:micrometer-registry-otlp")
  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.springframework.boot:spring-boot-testcontainers")
  testImplementation("com.netflix.graphql.dgs:graphql-dgs-spring-graphql-starter-test")
  testImplementation("org.springframework.batch:spring-batch-test")
  testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
  testImplementation("org.springframework.security:spring-security-test")
  testImplementation("org.testcontainers:elasticsearch")
  testImplementation("org.testcontainers:junit-jupiter")
  testImplementation("org.testcontainers:mysql")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  testImplementation("org.quickperf:quick-perf-junit5")
  testImplementation("io.github.autoparams:autoparams:11.3.0")
}

dependencyManagement {
  imports {
    mavenBom(
        "com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:${property("netflixDgsVersion")}")
    mavenBom("org.quickperf:quick-perf-bom:1.1.0")
  }
}

tasks.generateJava {
  schemaPaths.add("${projectDir}/src/main/resources/schema")
  packageName = "io.moira.codegen"
  generateClient = true
}

hibernate { enhancement { enableAssociationManagement = true } }

tasks.withType<Test> { useJUnitPlatform() }

tasks.test { outputs.dir(project.extra["snippetsDir"]!!) }

tasks.asciidoctor {
  inputs.dir(project.extra["snippetsDir"]!!)
  dependsOn(tasks.test)
}
