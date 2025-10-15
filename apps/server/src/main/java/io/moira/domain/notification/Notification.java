package io.moira.domain.notification;

import io.moira.domain.user.UserId;
import io.moira.shared.domain.AggregateRoot;
import java.time.OffsetDateTime;
import org.springframework.util.Assert;

public class Notification extends AggregateRoot<NotificationId> {

  protected UserId recipient;
  protected NotificationType type;
  protected OffsetDateTime createdAt;

  protected Notification(NotificationId id, UserId recipient, NotificationType type) {
    super(id);

    Assert.notNull(recipient, "Recipient ID must not be null");
    Assert.notNull(type, "Notification type must not be null");

    this.recipient = recipient;
    this.type = type;
  }

  public Notification(
      NotificationId id, UserId recipient, NotificationType type, OffsetDateTime createdAt) {
    this(id, recipient, type);
    this.createdAt = createdAt;
  }

  public UserId getRecipient() {
    return recipient;
  }

  public NotificationType getType() {
    return type;
  }

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }
}
