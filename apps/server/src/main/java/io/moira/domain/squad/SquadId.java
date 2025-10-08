package io.moira.domain.squad;

import io.moira.shared.domain.ValueObject;
import java.util.UUID;
import org.springframework.util.Assert;

public class SquadId extends ValueObject {

  private final UUID value;

  public SquadId(UUID value) {
    Assert.notNull(value, "Squad ID must not be null");
    this.value = value;
  }

  @Override
  public Object value() {
    return value;
  }

  public static SquadId of(String value) {
    return new SquadId(UUID.fromString(value));
  }
}
