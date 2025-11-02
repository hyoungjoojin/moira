package io.moira.infrastructure.persistence.notification.entity;

import io.moira.domain.friend.FriendshipId;
import io.moira.domain.notification.FriendRequestNotification;
import io.moira.domain.notification.Notification;
import io.moira.domain.notification.NotificationId;
import io.moira.domain.notification.NotificationType;
import io.moira.domain.user.UserId;
import io.moira.infrastructure.persistence.friend.entity.FriendshipEntity;
import io.moira.infrastructure.persistence.user.entity.UserEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = NotificationType.Values.FRIEND_REQUEST)
public class FriendRequestNotificationEntity extends NotificationEntity {

  @OneToOne(fetch = FetchType.LAZY)
  private FriendshipEntity friendship;

  @Override
  public Notification toDomain() {
    NotificationId notificationId = new NotificationId(id);
    UserId userId = new UserId(user.getId());
    FriendshipId friendshipId = new FriendshipId(friendship.getId());

    return new FriendRequestNotification(notificationId, userId, friendshipId, createdAt);
  }

  public static FriendRequestNotificationEntity fromDomain(FriendRequestNotification notification) {
    FriendRequestNotificationEntity entity = new FriendRequestNotificationEntity();
    entity.id = notification.getId().value();
    entity.user = UserEntity.of(notification.getRecipient().value());
    entity.createdAt = notification.getCreatedAt();
    entity.friendship = FriendshipEntity.of(notification.getFriendshipId().value());
    return entity;
  }
}
