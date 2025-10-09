package io.moira.interfaces.graphql.endpoints.mutation;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import io.moira.application.squad.InviteUserToSquadCommand;
import io.moira.application.squad.InviteUserToSquadUseCase;
import io.moira.domain.squad.SquadId;
import io.moira.domain.user.UserId;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@DgsComponent
public class InviteUserToSquad {

  private final InviteUserToSquadUseCase inviteUserToSquadUseCase;

  public InviteUserToSquad(InviteUserToSquadUseCase inviteUserToSquadUseCase) {
    this.inviteUserToSquadUseCase = inviteUserToSquadUseCase;
  }

  @DgsMutation(field = "inviteUserToSquad")
  @PreAuthorize("isAuthenticated()")
  public void inviteUserToSquad(
      @AuthenticationPrincipal String inviterId, @InputArgument InviteUserToSquadInput input) {
    UserId inviter = UserId.of(inviterId);
    inviteUserToSquadUseCase.execute(input.toCommand(inviter));
  }
}

record InviteUserToSquadInput(String userId, String squadId) {

  public InviteUserToSquadCommand toCommand(UserId inviter) {
    return new InviteUserToSquadCommand(inviter, UserId.of(userId), SquadId.of(squadId));
  }
}
