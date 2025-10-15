package io.moira.interfaces.graphql.dto;

import io.moira.domain.notification.Notification;
import io.moira.domain.notification.NotificationType;
import io.moira.domain.notification.SquadInviteNotification;
import java.time.OffsetDateTime;

public interface NotificationView {

  public NotificationType type();

  public String id();

  public OffsetDateTime createdAt();

  public static record SquadInviteNotificationView(
      NotificationType type, String id, OffsetDateTime createdAt, String invitationId)
      implements NotificationView {}

  public static NotificationView fromDomain(Notification notification) {
    NotificationType type = notification.getType();
    String id = notification.getId().toString();
    OffsetDateTime createdAt = notification.getCreatedAt();

    switch (type) {
      case SQUAD_INVITE:
        SquadInviteNotification squadInviteNotification = (SquadInviteNotification) notification;
        return new SquadInviteNotificationView(
            type, id, createdAt, squadInviteNotification.getInvitation().toString());

      default:
        throw new IllegalArgumentException();
    }
  }
}
