package io.moira.domain.user;

import io.moira.shared.domain.ValueObject;
import java.util.UUID;
import org.springframework.util.Assert;

public class UserId extends ValueObject {

  private final UUID value;

  public UserId(UUID value) {
    Assert.notNull(value, "User ID must not be null");
    this.value = value;
  }

  @Override
  public UUID value() {
    return value;
  }

  public static UserId create() {
    UserId id = new UserId(UUID.randomUUID());
    return id;
  }

  public static UserId of(String value) {
    return new UserId(UUID.fromString(value));
  }
}
