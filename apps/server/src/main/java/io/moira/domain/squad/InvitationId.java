package io.moira.domain.squad;

import io.moira.shared.domain.ValueObject;
import java.util.UUID;
import org.springframework.util.Assert;

public class InvitationId extends ValueObject {

  private final UUID value;

  public InvitationId(UUID value) {
    Assert.notNull(value, "User ID must not be null");
    this.value = value;
  }

  @Override
  public UUID value() {
    return value;
  }

  public static InvitationId create() {
    InvitationId id = new InvitationId(UUID.randomUUID());
    return id;
  }

  public static InvitationId of(String value) {
    return new InvitationId(UUID.fromString(value));
  }
}
