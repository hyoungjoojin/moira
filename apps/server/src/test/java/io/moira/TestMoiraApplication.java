package io.moira;

import io.moira.config.TestcontainersConfig;
import org.springframework.boot.SpringApplication;

public class TestMoiraApplication {

  public static void main(String[] args) {
    SpringApplication.from(MoiraApplication::main).with(TestcontainersConfig.class).run(args);
  }
}
