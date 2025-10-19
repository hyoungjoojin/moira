package io.moira.application.notification.events;

import io.moira.domain.notification.Notification;
import io.moira.domain.notification.NotificationRepository;
import io.moira.domain.notification.SquadInviteNotification;
import io.moira.domain.squad.invitation.InvitationCreatedEvent;
import io.moira.shared.domain.UseCase;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@UseCase
class InvitationCreatedEventHandlerUseCase {

  private final NotificationRepository notificationRepository;

  public InvitationCreatedEventHandlerUseCase(NotificationRepository notificationRepository) {
    this.notificationRepository = notificationRepository;
  }

  @EventListener
  public Notification execute(InvitationCreatedEvent event) {
    SquadInviteNotification notification =
        SquadInviteNotification.create(event.getInvitationFor(), event.getInvitationId());
    notificationRepository.save(notification);
    return notification;
  }
}
