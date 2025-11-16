package io.moira.interfaces.graphql.datafetcher.data.user;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.InputArgument;
import io.moira.application.friend.GetFriendsByUserUseCase;
import io.moira.application.friend.GetFriendsByUserUseCase.GetFriendsByUserQuery;
import io.moira.application.friend.GetFriendsByUserUseCase.GetFriendsByUserResult;
import io.moira.domain.friend.Friendship;
import io.moira.domain.friend.FriendshipId;
import io.moira.domain.user.User;
import io.moira.domain.user.UserId;
import io.moira.interfaces.graphql.dataloader.FriendshipDataLoader;
import io.moira.interfaces.graphql.dataloader.UserDataLoader;
import io.moira.interfaces.graphql.dto.PageInfo;
import io.moira.interfaces.graphql.dto.UserView;
import io.moira.interfaces.graphql.dto.friend.FriendConnection;
import io.moira.interfaces.graphql.dto.friend.FriendEdge;
import io.moira.interfaces.graphql.dto.friend.FriendshipView;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.dataloader.DataLoader;

@DgsComponent
public class UserFriendsDataFetcher {

  private final GetFriendsByUserUseCase getFriendsByUserUseCase;

  public UserFriendsDataFetcher(GetFriendsByUserUseCase getFriendsByUserUseCase) {
    this.getFriendsByUserUseCase = getFriendsByUserUseCase;
  }

  @DgsData(parentType = "User", field = "friends")
  public CompletableFuture<FriendConnection> friends(
      DgsDataFetchingEnvironment dfe, @InputArgument Integer first, @InputArgument String after) {
    UserView user = dfe.getSource();

    GetFriendsByUserQuery query = new GetFriendsByUserQuery(UserId.of(user.id()), first, after);
    GetFriendsByUserResult result = getFriendsByUserUseCase.execute(query);

    String cursor =
        result.friendships().isEmpty() ? null : result.friendships().getLast().getId().toString();

    PageInfo pageInfo = new PageInfo(result.hasNext(), result.hasPrevious(), cursor);

    return CompletableFuture.completedFuture(
        new FriendConnection(
            result.totalCount(),
            result.friendships().stream()
                .map(friendship -> FriendEdge.fromDomain(friendship))
                .toList(),
            pageInfo));
  }

  @DgsData(parentType = "FriendConnection", field = "nodes")
  public CompletableFuture<List<FriendshipView>> nodes(DgsDataFetchingEnvironment dfe) {
    FriendConnection friendConnection = dfe.getSource();

    DataLoader<FriendshipId, Friendship> dataloader = dfe.getDataLoader(FriendshipDataLoader.class);
    return dataloader
        .loadMany(
            friendConnection.edges().stream().map(edge -> FriendshipId.of(edge.node())).toList())
        .thenApply(list -> list.stream().map(FriendshipView::fromDomain).toList());
  }

  @DgsData(parentType = "Friendship", field = "rightUser")
  public CompletableFuture<UserView> user(DgsDataFetchingEnvironment dfe) {
    FriendshipView friendshipView = dfe.getSource();

    DataLoader<UserId, User> dataloader = dfe.getDataLoader(UserDataLoader.class);

    return dataloader.load(UserId.of(friendshipView.rightUser())).thenApply(UserView::fromDomain);
  }
}
