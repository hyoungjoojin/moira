package io.moira.domain.squad;

import io.moira.shared.domain.ValueObject;
import java.util.UUID;
import org.springframework.util.Assert;

public class MemberId extends ValueObject {

  private final UUID value;

  public MemberId(UUID value) {
    Assert.notNull(value, "Member ID must not be null");
    this.value = value;
  }

  @Override
  public UUID value() {
    return value;
  }

  public static MemberId create() {
    MemberId id = new MemberId(UUID.randomUUID());
    return id;
  }

  public static MemberId of(String value) {
    MemberId id = new MemberId(UUID.fromString(value));
    return id;
  }
}
