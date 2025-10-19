package io.moira.interfaces.graphql.endpoints.query;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.DgsTypeResolver;
import io.moira.application.notification.services.NotificationService;
import io.moira.domain.user.UserId;
import io.moira.interfaces.graphql.dto.NotificationView;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@DgsComponent
public class NotificationsQuery {

  private static final Logger logger = LoggerFactory.getLogger(NotificationsQuery.class);

  private final NotificationService notificationService;

  public NotificationsQuery(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @DgsQuery(field = "notifications")
  public List<NotificationView> getNotifications(@AuthenticationPrincipal String userId) {
    UserId user = UserId.of(userId);
    return notificationService.getNotificationsByRecipient(user).stream()
        .map(NotificationView::fromDomain)
        .toList();
  }

  @DgsTypeResolver(name = "Notification")
  public String resolve(NotificationView notification) {
    System.out.println(notification);
    switch (notification.type()) {
      case SQUAD_INVITE:
        return "SquadInviteNotification";

      default:
        logger.debug("Unknown notification type {}", notification.type());
        throw new IllegalArgumentException();
    }
  }
}
