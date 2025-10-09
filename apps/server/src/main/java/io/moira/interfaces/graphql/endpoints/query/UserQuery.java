package io.moira.interfaces.graphql.endpoints.query;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import io.moira.application.user.UserService;
import io.moira.application.user.exception.UserNotFoundException;
import io.moira.domain.user.User;
import io.moira.domain.user.UserId;
import io.moira.interfaces.graphql.dto.UserView;

@DgsComponent
public class UserQuery {

  private final UserService userService;

  public UserQuery(UserService userService) {
    this.userService = userService;
  }

  @DgsQuery(field = "user")
  public UserView getSquad(@InputArgument String id) throws UserNotFoundException {
    UserId userId = UserId.of(id);
    User user = userService.getUserById(userId);
    return UserView.fromDomain(user);
  }
}
