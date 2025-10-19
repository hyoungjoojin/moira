package io.moira;

import io.moira.config.TestcontainersConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfig.class)
@SpringBootTest
class MoiraApplicationTests {

  @Test
  void contextLoads() {}
}
