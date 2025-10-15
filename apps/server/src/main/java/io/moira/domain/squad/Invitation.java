package io.moira.domain.squad;

import io.moira.domain.user.UserId;
import io.moira.shared.domain.AggregateRoot;
import java.time.OffsetDateTime;
import org.springframework.util.Assert;

public class Invitation extends AggregateRoot<InvitationId> {

  private UserId inviter;
  private UserId invitee;
  private SquadId squad;
  private OffsetDateTime sentAt;
  private InvitationStatus status;

  private Invitation(InvitationId id, UserId inviter, UserId invitee, SquadId squad) {
    super(id);

    Assert.notNull(inviter, "Inviter ID must not be null");
    Assert.notNull(invitee, "Invitee ID must not be null");
    Assert.notNull(squad, "Squad ID must not be null");

    this.inviter = inviter;
    this.invitee = invitee;
    this.squad = squad;
    this.sentAt = OffsetDateTime.now();
    this.status = InvitationStatus.PENDING;
  }

  public Invitation(
      InvitationId id,
      UserId inviter,
      UserId invitee,
      SquadId squad,
      OffsetDateTime sentAt,
      InvitationStatus status) {
    this(id, inviter, invitee, squad);

    this.sentAt = sentAt;
    this.status = status;
  }

  public static Invitation create(UserId inviter, UserId invitee, SquadId squad) {
    Invitation invitation = new Invitation(InvitationId.create(), inviter, invitee, squad);
    invitation.registerEvent(new InvitationCreatedEvent(invitee, invitation.getId()));

    return invitation;
  }

  public UserId getInviter() {
    return inviter;
  }

  public UserId getInvitee() {
    return invitee;
  }

  public SquadId getSquad() {
    return squad;
  }

  public OffsetDateTime getSentAt() {
    return sentAt;
  }

  public InvitationStatus getStatus() {
    return status;
  }

  public void acceptInvitation() {
    status = InvitationStatus.ACCEPTED;
  }

  public void rejectInvitation() {
    status = InvitationStatus.REJECTED;
  }
}
