package io.moira.infrastructure.persistence.squad;

import io.moira.domain.squad.Invitation;
import io.moira.domain.squad.InvitationId;
import io.moira.domain.squad.InvitationStatus;
import io.moira.domain.squad.SquadId;
import io.moira.domain.user.UserId;
import io.moira.infrastructure.persistence.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "invitations")
public class InvitationEntity {

  @Id
  @Column(name = "invitation_id")
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inviter_id", nullable = false)
  private UserEntity inviter;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "invitee_id", nullable = false)
  private UserEntity invitee;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "squad_id", nullable = false)
  private SquadEntity squad;

  @Column(name = "sent_at", nullable = false)
  private OffsetDateTime sentAt;

  protected InvitationEntity() {}

  public Invitation toDomain() {
    InvitationId id = new InvitationId(this.id);
    UserId inviter = new UserId(this.inviter.getId()), invitee = new UserId(this.invitee.getId());
    SquadId squad = new SquadId(this.squad.getId());

    return new Invitation(id, inviter, invitee, squad, sentAt, InvitationStatus.PENDING);
  }

  public static InvitationEntity fromDomain(Invitation invitation) {
    InvitationEntity entity = new InvitationEntity();
    entity.id = invitation.getId().value();
    entity.inviter = UserEntity.of(invitation.getInviter().value());
    entity.invitee = UserEntity.of(invitation.getInvitee().value());
    entity.squad = SquadEntity.of(invitation.getSquad().value());
    entity.sentAt = invitation.getSentAt();

    return entity;
  }
}
