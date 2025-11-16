package io.moira.domain.friend;

import io.moira.shared.domain.ValueObject;
import java.util.UUID;
import org.springframework.util.Assert;

public class FriendshipId extends ValueObject {

  private final UUID value;

  public FriendshipId(UUID value) {
    Assert.notNull(value, "Friendship ID must not be null");
    this.value = value;
  }

  @Override
  public UUID value() {
    return value;
  }

  public static FriendshipId create() {
    return new FriendshipId(UUID.randomUUID());
  }

  public static FriendshipId of(String value) {
    return new FriendshipId(UUID.fromString(value));
  }
}
