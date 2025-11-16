package io.moira.interfaces.graphql.datafetcher.data.user;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import io.moira.domain.friend.Friendship;
import io.moira.domain.user.UserId;
import io.moira.interfaces.graphql.dataloader.FriendshipDataLoader;
import io.moira.interfaces.graphql.dto.UserView;
import io.moira.interfaces.graphql.dto.friend.FriendshipView;
import io.moira.shared.util.Pair;
import java.util.concurrent.CompletableFuture;
import org.dataloader.DataLoader;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@DgsComponent
public class UserViewerRelationDataFetcher {

  @DgsData(parentType = "User", field = "viewerRelation")
  public CompletableFuture<FriendshipView> viewerRelation(
      @AuthenticationPrincipal String userId, DgsDataFetchingEnvironment dfe) {
    UserView source = dfe.getSource();

    DataLoader<Pair<UserId, UserId>, Friendship> dataloader =
        dfe.getDataLoader(FriendshipDataLoader.class);

    return dataloader
        .load(Pair.create(UserId.of(userId), UserId.of(source.id())))
        .thenApply(FriendshipView::fromDomain);
  }
}
