package io.moira.interfaces.graphql.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import io.moira.application.squad.services.SquadService;
import io.moira.domain.squad.SquadId;
import io.moira.domain.squad.invitation.Invitation;
import io.moira.domain.squad.invitation.InvitationId;
import io.moira.interfaces.graphql.dto.InvitationView;
import io.moira.interfaces.graphql.dto.NotificationView.SquadInviteNotificationView;
import io.moira.interfaces.graphql.dto.SquadView;
import java.util.List;

@DgsComponent
public class InvitationDataFetcher {

  private final SquadService squadService;

  public InvitationDataFetcher(SquadService squadService) {
    this.squadService = squadService;
  }

  @DgsData(parentType = "Squad", field = "invitations")
  public List<InvitationView> squad(DgsDataFetchingEnvironment dfe) {
    SquadView squad = dfe.getSource();
    return squadService.getAllInvitationsForSquad(SquadId.of(squad.id())).stream()
        .map(InvitationView::fromDomain)
        .toList();
  }

  @DgsData(parentType = "SquadInviteNotification", field = "invitation")
  public InvitationView squadInviteNotification(DgsDataFetchingEnvironment dfe) {
    SquadInviteNotificationView notification = dfe.getSource();
    Invitation invitation =
        squadService.getInvitation(InvitationId.of(notification.invitationId()));
    return InvitationView.fromDomain(invitation);
  }
}
