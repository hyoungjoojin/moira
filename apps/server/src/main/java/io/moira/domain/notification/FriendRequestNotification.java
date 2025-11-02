package io.moira.domain.notification;

import io.moira.domain.friend.FriendshipId;
import io.moira.domain.user.UserId;
import java.time.OffsetDateTime;
import org.springframework.util.Assert;

public class FriendRequestNotification extends Notification {

  private final FriendshipId friendshipId;

  private FriendRequestNotification(
      NotificationId notificationId, UserId recipient, FriendshipId friendshipId) {
    super(notificationId, recipient, NotificationType.FRIEND_REQUEST);

    Assert.notNull(friendshipId, "Friendship ID must not be null");

    this.friendshipId = friendshipId;
  }

  public FriendRequestNotification(
      NotificationId notificationId,
      UserId recipient,
      FriendshipId friendshipId,
      OffsetDateTime createdAt) {
    this(notificationId, recipient, friendshipId);
    this.createdAt = createdAt;
  }

  public static FriendRequestNotification create(UserId recipient, FriendshipId friendshipId) {
    FriendRequestNotification notification =
        new FriendRequestNotification(NotificationId.create(), recipient, friendshipId);
    notification.createdAt = OffsetDateTime.now();
    return notification;
  }

  public FriendshipId getFriendshipId() {
    return friendshipId;
  }
}
