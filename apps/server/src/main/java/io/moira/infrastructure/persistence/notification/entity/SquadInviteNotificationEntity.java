package io.moira.infrastructure.persistence.notification.entity;

import io.moira.domain.notification.NotificationId;
import io.moira.domain.notification.NotificationType;
import io.moira.domain.notification.SquadInviteNotification;
import io.moira.domain.squad.invitation.InvitationId;
import io.moira.domain.user.UserId;
import io.moira.infrastructure.persistence.squad.entity.InvitationEntity;
import io.moira.infrastructure.persistence.user.entity.UserEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = NotificationType.Values.SQUAD_INVITE)
public class SquadInviteNotificationEntity extends NotificationEntity {

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "invitation_id", nullable = false)
  private InvitationEntity invitation;

  @Override
  public SquadInviteNotification toDomain() {
    NotificationId notificationId = new NotificationId(id);
    UserId userId = new UserId(user.getId());
    InvitationId invitation = new InvitationId(this.invitation.getId());
    return new SquadInviteNotification(notificationId, userId, invitation, createdAt);
  }

  public static SquadInviteNotificationEntity fromDomain(SquadInviteNotification notification) {
    SquadInviteNotificationEntity entity = new SquadInviteNotificationEntity();
    entity.id = notification.getId().value();
    entity.user = UserEntity.of(notification.getRecipient().value());
    entity.createdAt = notification.getCreatedAt();
    entity.invitation = InvitationEntity.of(notification.getInvitation().value());
    return entity;
  }
}
