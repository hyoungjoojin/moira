plugins {
  java
  id("org.springframework.boot") version "3.5.5"
  id("io.spring.dependency-management") version "1.1.7"
  id("com.netflix.dgs.codegen") version "7.0.3"
  id("org.hibernate.orm") version "6.6.26.Final"
  id("org.graalvm.buildtools.native") version "0.10.6"
}

group = "io"

version = "0.0.1-SNAPSHOT"

description = ""

java { toolchain { languageVersion = JavaLanguageVersion.of(24) } }

configurations { compileOnly { extendsFrom(configurations.annotationProcessor.get()) } }

repositories { mavenCentral() }

extra["netflixDgsVersion"] = "10.2.1"

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-data-redis")
  implementation("org.springframework.boot:spring-boot-starter-jooq")
  implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-websocket")
  implementation("com.netflix.graphql.dgs:graphql-dgs-spring-graphql-starter")
  implementation("org.flywaydb:flyway-core")
  implementation("org.flywaydb:flyway-mysql")
  implementation("org.springframework.session:spring-session-data-redis")
  compileOnly("org.projectlombok:lombok")
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  developmentOnly("org.springframework.boot:spring-boot-docker-compose")
  runtimeOnly("com.mysql:mysql-connector-j")
  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
  annotationProcessor("org.projectlombok:lombok")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("com.netflix.graphql.dgs:graphql-dgs-spring-graphql-starter-test")
  testImplementation("org.springframework.security:spring-security-test")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
  imports {
    mavenBom(
        "com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:${property("netflixDgsVersion")}")
  }
}

tasks.generateJava {
  schemaPaths.add("${projectDir}/src/main/resources/schema")
  packageName = "io.moira.codegen"
  generateClient = true
}

hibernate { enhancement { enableAssociationManagement = true } }

tasks.withType<Test> { useJUnitPlatform() }
