package io.moira.interfaces.graphql.dto.friend;

import io.moira.domain.friend.Friendship;
import io.moira.domain.friend.FriendshipStatus;
import java.time.OffsetDateTime;

public record FriendshipView(
    String leftUser, String rightUser, FriendshipStatus status, OffsetDateTime since) {

  public static FriendshipView fromDomain(Friendship friendship) {
    return new FriendshipView(
        friendship.getLeftUser().toString(),
        friendship.getRightUser().toString(),
        friendship.getStatus(),
        friendship.getFriendsSince());
  }
}
