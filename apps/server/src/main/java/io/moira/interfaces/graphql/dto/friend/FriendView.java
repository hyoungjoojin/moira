package io.moira.interfaces.graphql.dto.friend;

import io.moira.domain.friend.Friendship;
import java.time.OffsetDateTime;

public record FriendView(String node, OffsetDateTime friendsSince, String cursor) {

  public static FriendView fromDomain(String userId, Friendship friendship) {
    String userAId = friendship.getUserA().toString(), userBId = friendship.getUserB().toString();
    String friendId = (userId.equals(userAId)) ? userBId : userAId;

    return new FriendView(friendId, friendship.getCreatedAt(), friendId);
  }
}
