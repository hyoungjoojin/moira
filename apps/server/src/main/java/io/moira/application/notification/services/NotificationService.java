package io.moira.application.notification.services;

import io.moira.domain.notification.Notification;
import io.moira.domain.notification.NotificationRepository;
import io.moira.domain.user.UserId;
import io.moira.shared.domain.UseCase;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

  private final NotificationRepository notificationRepository;

  public NotificationService(NotificationRepository notificationRepository) {
    this.notificationRepository = notificationRepository;
  }

  @UseCase
  public List<Notification> getNotificationsByRecipient(UserId user) {
    return notificationRepository.findAllByRecipient(user);
  }
}
