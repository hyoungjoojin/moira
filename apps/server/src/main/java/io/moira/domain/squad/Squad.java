package io.moira.domain.squad;

import io.moira.domain.user.UserId;
import io.moira.shared.domain.AggregateRoot;
import java.time.OffsetDateTime;
import org.springframework.util.Assert;

public class Squad extends AggregateRoot<SquadId> {

  private String name;
  private OffsetDateTime createdAt;

  private Squad(SquadId id, String name) {
    super(id);

    Assert.notNull(name, "The squad's name must not be null");

    this.name = name;
  }

  public Squad(SquadId id, String name, OffsetDateTime createdAt) {
    this(id, name);

    this.createdAt = createdAt;
  }

  public static Squad create(UserId creatorId, String name) {
    SquadId squadId = SquadId.create();
    Squad squad = new Squad(squadId, name);
    squad.createdAt = OffsetDateTime.now();

    return squad;
  }

  public String getName() {
    return name;
  }

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }
}
