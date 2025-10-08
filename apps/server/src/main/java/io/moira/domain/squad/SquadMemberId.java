package io.moira.domain.squad;

import io.moira.domain.user.UserId;
import io.moira.shared.domain.ValueObject;
import org.springframework.util.Assert;

public class SquadMemberId extends ValueObject {

  private final UserId userId;
  private final SquadId squadId;

  public SquadMemberId(UserId userId, SquadId squadId) {
    Assert.notNull(userId, "User ID must not be null");
    Assert.notNull(squadId, "Squad ID must not be null");

    this.userId = userId;
    this.squadId = squadId;
  }

  @Override
  public Object value() {
    return userId.value().toString() + squadId.value().toString();
  }
}
