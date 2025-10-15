package io.moira.domain.notification;

import io.moira.domain.squad.InvitationId;
import io.moira.domain.user.UserId;
import java.time.OffsetDateTime;
import org.springframework.util.Assert;

public class SquadInviteNotification extends Notification {

  private final InvitationId invitation;

  private SquadInviteNotification(
      NotificationId notificationId, UserId user, InvitationId invitation) {
    super(notificationId, user, NotificationType.SQUAD_INVITE);

    Assert.notNull(invitation, "Invitation ID must not be null");

    this.invitation = invitation;
  }

  public SquadInviteNotification(
      NotificationId notificationId,
      UserId user,
      InvitationId invitation,
      OffsetDateTime createdAt) {
    this(notificationId, user, invitation);
    this.createdAt = createdAt;
  }

  public static SquadInviteNotification create(UserId user, InvitationId invitation) {
    SquadInviteNotification notification =
        new SquadInviteNotification(NotificationId.create(), user, invitation);
    notification.createdAt = OffsetDateTime.now();
    return notification;
  }

  public InvitationId getInvitation() {
    return invitation;
  }
}
