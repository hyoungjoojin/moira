package io.moira.interfaces.graphql.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import io.moira.domain.user.User;
import io.moira.domain.user.UserId;
import io.moira.interfaces.graphql.dataloader.UsersDataloader;
import io.moira.interfaces.graphql.dto.MemberView;
import io.moira.interfaces.graphql.dto.UserView;
import java.util.concurrent.CompletableFuture;
import org.dataloader.DataLoader;

@DgsComponent
public class UserDatafetcher {

  @DgsData.List({
    @DgsData(parentType = "Member", field = "user"),
    @DgsData(parentType = "Member", field = "invitedBy")
  })
  public CompletableFuture<UserView> memberUser(DgsDataFetchingEnvironment dfe) {
    Object source = dfe.getSource();
    if (!(source instanceof MemberView)) {
      throw new IllegalArgumentException();
    }

    MemberView member = (MemberView) source;
    DataLoader<UserId, User> dataloader = dfe.getDataLoader(UsersDataloader.class);

    return dataloader.load(UserId.of(member.userId())).thenApply(UserView::fromDomain);
  }
}
