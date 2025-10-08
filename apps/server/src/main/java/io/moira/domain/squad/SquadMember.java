package io.moira.domain.squad;

import io.moira.domain.user.UserId;
import io.moira.shared.domain.Entity;
import java.time.OffsetDateTime;

public class SquadMember extends Entity<SquadMemberId> {

  private OffsetDateTime joinedAt;
  private UserId invitedBy;

  public SquadMember(SquadMemberId id) {
    super(id);
  }
}
