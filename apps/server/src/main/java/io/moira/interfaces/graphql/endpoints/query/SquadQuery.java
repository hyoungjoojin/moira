package io.moira.interfaces.graphql.endpoints.query;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import io.moira.application.squad.exception.SquadNotFoundException;
import io.moira.application.squad.services.SquadService;
import io.moira.domain.squad.Squad;
import io.moira.domain.squad.SquadId;
import io.moira.interfaces.graphql.dto.SquadView;

@DgsComponent
public class SquadQuery {

  private final SquadService squadService;

  public SquadQuery(SquadService squadService) {
    this.squadService = squadService;
  }

  @DgsQuery(field = "squad")
  public SquadView getSquad(@InputArgument String id) throws SquadNotFoundException {
    SquadId squadId = SquadId.of(id);
    Squad squad = squadService.getSquad(squadId);
    return SquadView.fromDomain(squad);
  }
}
