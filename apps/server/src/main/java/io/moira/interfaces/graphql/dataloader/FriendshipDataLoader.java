package io.moira.interfaces.graphql.dataloader;

import com.netflix.graphql.dgs.DgsDataLoader;
import io.moira.application.friend.services.FriendService;
import io.moira.domain.friend.Friendship;
import io.moira.domain.friend.FriendshipId;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.dataloader.BatchLoader;

@DgsDataLoader(name = "friendships")
public class FriendshipDataLoader implements BatchLoader<FriendshipId, Friendship> {

  private final FriendService friendService;

  public FriendshipDataLoader(FriendService friendService) {
    this.friendService = friendService;
  }

  @Override
  public CompletionStage<List<Friendship>> load(List<FriendshipId> keys) {
    return CompletableFuture.supplyAsync(() -> friendService.getFriendshipsByIds(keys));
  }
}
