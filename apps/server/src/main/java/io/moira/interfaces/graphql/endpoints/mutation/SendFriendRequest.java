package io.moira.interfaces.graphql.endpoints.mutation;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import io.moira.application.friend.exception.FriendshipAlreadyExistsException;
import io.moira.application.friend.services.sendFriendRequest.SendFriendRequestCommand;
import io.moira.application.friend.services.sendFriendRequest.SendFriendRequestUseCase;
import io.moira.domain.friend.Friendship;
import io.moira.domain.user.UserId;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@DgsComponent
public class SendFriendRequest {

  private final SendFriendRequestUseCase sendFriendRequestUseCase;

  public SendFriendRequest(SendFriendRequestUseCase sendFriendRequestUseCase) {
    this.sendFriendRequestUseCase = sendFriendRequestUseCase;
  }

  @DgsMutation(field = "sendFriendRequest")
  public String sendFriendRequest(
      @AuthenticationPrincipal String userId, @InputArgument SendFriendRequestInput input)
      throws FriendshipAlreadyExistsException {
    Friendship friendship = sendFriendRequestUseCase.execute(input.toCommand(userId));
    return friendship.getId().toString();
  }
}

record SendFriendRequestInput(String friendId) {

  SendFriendRequestCommand toCommand(String requesterId) {
    return new SendFriendRequestCommand(UserId.of(requesterId), UserId.of(friendId));
  }
}
