package io.moira;

import org.springframework.boot.SpringApplication;

public class TestMoiraApplication {

  public static void main(String[] args) {
    SpringApplication.from(MoiraApplication::main)
        .with(TestcontainersConfiguration.class)
        .run(args);
  }
}
