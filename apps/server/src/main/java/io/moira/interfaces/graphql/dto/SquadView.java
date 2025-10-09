package io.moira.interfaces.graphql.dto;

import io.moira.domain.squad.Squad;
import java.time.OffsetDateTime;

public record SquadView(String id, String name, OffsetDateTime createdAt) {

  public static SquadView fromDomain(Squad squad) {
    return new SquadView(squad.getId().toString(), squad.getName(), squad.getCreatedAt());
  }
}
