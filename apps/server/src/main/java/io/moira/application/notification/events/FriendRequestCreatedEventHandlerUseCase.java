package io.moira.application.notification.events;

import io.moira.domain.friend.FriendRequestCreatedEvent;
import io.moira.domain.notification.FriendRequestNotification;
import io.moira.domain.notification.NotificationRepository;
import io.moira.shared.domain.UseCase;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@UseCase
public class FriendRequestCreatedEventHandlerUseCase {

  private final NotificationRepository notificationRepository;
  private final ApplicationEventPublisher eventPublisher;

  public FriendRequestCreatedEventHandlerUseCase(
      NotificationRepository notificationRepository, ApplicationEventPublisher eventPublisher) {
    this.notificationRepository = notificationRepository;
    this.eventPublisher = eventPublisher;
  }

  @EventListener
  public void execute(FriendRequestCreatedEvent event) {
    FriendRequestNotification notification =
        FriendRequestNotification.create(event.getRecipient(), event.getFriendship());
    notificationRepository.save(notification);
    notification.publishEvents(eventPublisher);
  }
}
