package io.moira.interfaces.graphql.dto.friend;

import io.moira.domain.friend.Friendship;

public record FriendEdge(String node, String cursor) {

  public static FriendEdge fromDomain(Friendship friendship) {
    return new FriendEdge(friendship.getId().toString(), friendship.getId().toString());
  }
}
