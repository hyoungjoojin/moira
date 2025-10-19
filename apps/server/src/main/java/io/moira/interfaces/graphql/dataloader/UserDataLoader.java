package io.moira.interfaces.graphql.dataloader;

import com.netflix.graphql.dgs.DgsDataLoader;
import io.moira.application.user.services.UserService;
import io.moira.domain.user.User;
import io.moira.domain.user.UserId;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.dataloader.BatchLoader;

@DgsDataLoader(name = "users")
public class UserDataLoader implements BatchLoader<UserId, User> {

  private final UserService userService;

  public UserDataLoader(UserService userService) {
    this.userService = userService;
  }

  @Override
  public CompletionStage<List<User>> load(List<UserId> userIds) {
    return CompletableFuture.supplyAsync(() -> userService.getUsersByIds(userIds));
  }
}
