package io.moira.domain.notification;

import io.moira.shared.domain.DomainEvent;

public class NotificationCreatedEvent extends DomainEvent {

  private final Notification notification;

  public NotificationCreatedEvent(Notification notification) {
    this.notification = notification;
  }

  public Notification getNotification() {
    return notification;
  }
}
