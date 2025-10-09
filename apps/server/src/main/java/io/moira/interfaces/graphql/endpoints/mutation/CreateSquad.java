package io.moira.interfaces.graphql.endpoints.mutation;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import io.moira.application.squad.CreateSquadCommand;
import io.moira.application.squad.CreateSquadUseCase;
import io.moira.domain.squad.Squad;
import io.moira.domain.user.UserId;
import io.moira.interfaces.graphql.dto.SquadView;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@DgsComponent
public class CreateSquad {

  private final CreateSquadUseCase createSquadUseCase;

  public CreateSquad(CreateSquadUseCase createSquadUseCase) {
    this.createSquadUseCase = createSquadUseCase;
  }

  @DgsMutation(field = "createSquad")
  @PreAuthorize("isAuthenticated()")
  public SquadView createSquad(
      @AuthenticationPrincipal String userId, @InputArgument CreateSquadInput input) {
    Squad squad = createSquadUseCase.execute(input.toCommand(UserId.of(userId)));
    return SquadView.fromDomain(squad);
  }
}

record CreateSquadInput(String name) {

  public CreateSquadCommand toCommand(UserId creator) {
    return new CreateSquadCommand(creator, name);
  }
}
