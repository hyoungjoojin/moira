package io.moira.domain.notification;

import io.moira.shared.domain.ValueObject;
import java.util.UUID;
import org.springframework.util.Assert;

public class NotificationId extends ValueObject {

  private final UUID value;

  public NotificationId(UUID value) {
    Assert.notNull(value, "User ID must not be null");
    this.value = value;
  }

  @Override
  public UUID value() {
    return value;
  }

  public static NotificationId create() {
    return new NotificationId(UUID.randomUUID());
  }

  public static NotificationId of(String value) {
    return new NotificationId(UUID.fromString(value));
  }
}
