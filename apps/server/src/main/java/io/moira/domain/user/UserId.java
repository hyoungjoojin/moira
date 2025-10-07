package io.moira.domain.user;

import io.moira.shared.domain.ValueObject;
import java.util.UUID;

public class UserId extends ValueObject {

  private final UUID value;

  public UserId(UUID value) {
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
