package io.moira.interfaces.graphql.datafetcher.data.user;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import io.moira.application.friend.services.FriendService;
import io.moira.domain.user.UserId;
import io.moira.interfaces.graphql.dto.UserView;
import io.moira.interfaces.graphql.dto.friend.FriendshipView;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@DgsComponent
public class UserViewerRelationDataFetcher {

  private final FriendService friendService;

  public UserViewerRelationDataFetcher(FriendService friendService) {
    this.friendService = friendService;
  }

  @DgsData(parentType = "User", field = "viewerRelation")
  public FriendshipView viewerRelation(
      @AuthenticationPrincipal String userId, DgsDataFetchingEnvironment dfe) {
    UserView source = dfe.getSource();

    return FriendshipView.fromDomain(
        friendService.getRelationship(UserId.of(userId), UserId.of(source.id())));
  }
}
