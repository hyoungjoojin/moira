package io.moira.domain.friend;

import io.moira.domain.user.UserId;
import io.moira.shared.domain.DomainEvent;
import org.springframework.util.Assert;

public class FriendRequestCreatedEvent extends DomainEvent {

  private final UserId recipient;
  private final FriendshipId friendship;

  public FriendRequestCreatedEvent(UserId recipient, FriendshipId friendship) {
    Assert.notNull(recipient, "Recipient ID must not be null");
    Assert.notNull(friendship, "Friendship ID must not be null");

    this.recipient = recipient;
    this.friendship = friendship;
  }

  public UserId getRecipient() {
    return recipient;
  }

  public FriendshipId getFriendship() {
    return friendship;
  }
}
