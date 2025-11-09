package io.moira.interfaces.graphql.datafetcher.mutation;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import io.moira.application.friend.exception.FriendshipAlreadyExistsException;
import io.moira.application.friend.services.FriendService;
import io.moira.domain.user.UserId;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

record FriendRequestInput(String friendId) {}

@DgsComponent
public class FriendRequestDataFetcher {

  private final FriendService friendService;

  public FriendRequestDataFetcher(FriendService friendService) {
    this.friendService = friendService;
  }

  @DgsMutation(field = "sendFriendRequest")
  public void sendFriendRequest(
      @AuthenticationPrincipal String userId, @InputArgument FriendRequestInput input)
      throws FriendshipAlreadyExistsException {
    UserId from = UserId.of(userId), to = UserId.of(input.friendId());
    friendService.sendFriendRequest(from, to);
  }

  @DgsMutation(field = "acceptFriendRequest")
  public void acceptFriendRequest(
      @AuthenticationPrincipal String userId, @InputArgument FriendRequestInput input) {
    UserId to = UserId.of(userId), from = UserId.of(input.friendId());
    friendService.acceptFriendRequest(from, to);
  }

  @DgsMutation(field = "rejectFriendRequest")
  public void rejectFriendRequest(
      @AuthenticationPrincipal String userId, @InputArgument FriendRequestInput input) {
    UserId to = UserId.of(userId), from = UserId.of(input.friendId());
    friendService.rejectFriendRequest(from, to);
  }
}
