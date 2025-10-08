package io.moira.domain.squad;

import io.moira.shared.domain.AggregateRoot;
import java.time.OffsetDateTime;
import java.util.List;

public class Squad extends AggregateRoot<SquadId> {

  private String name;
  private List<SquadMemberId> members;
  private OffsetDateTime createdAt;

  public Squad(SquadId id) {
    super(id);
  }
}
