package io.moira.interfaces.graphql.squad.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import io.moira.application.squad.SquadService;
import io.moira.application.squad.exception.SquadNotFoundException;
import io.moira.domain.squad.SquadId;
import io.moira.interfaces.graphql.squad.dto.SquadView;

@DgsComponent
public class SquadDatafetcher {

  private final SquadService squadService;

  public SquadDatafetcher(SquadService squadService) {
    this.squadService = squadService;
  }

  @DgsQuery(field = "squad")
  public SquadView getSquad(@InputArgument String id) throws SquadNotFoundException {
    SquadId squadId = SquadId.of(id);
    squadService.getSquad(squadId);
    return null;
  }
}
