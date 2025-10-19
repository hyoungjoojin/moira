package io.moira.domain.squad.invitation;

import io.moira.domain.user.UserId;
import io.moira.shared.domain.DomainEvent;
import org.springframework.util.Assert;

public class InvitationCreatedEvent extends DomainEvent {

  private final UserId invitationFor;
  private final InvitationId invitationId;

  public InvitationCreatedEvent(UserId invitationFor, InvitationId invitationId) {
    Assert.notNull(invitationFor, "User ID must not be null");
    Assert.notNull(invitationId, "Invitation ID must not be null");

    this.invitationFor = invitationFor;
    this.invitationId = invitationId;
  }

  public UserId getInvitationFor() {
    return invitationFor;
  }

  public InvitationId getInvitationId() {
    return invitationId;
  }
}
