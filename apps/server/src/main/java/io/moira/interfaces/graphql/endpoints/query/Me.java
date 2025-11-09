package io.moira.interfaces.graphql.endpoints.query;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import io.moira.application.user.exception.UserNotFoundException;
import io.moira.application.user.services.UserService;
import io.moira.domain.user.User;
import io.moira.domain.user.UserId;
import io.moira.interfaces.graphql.dto.UserView;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@DgsComponent
public class Me {

  private final UserService userService;

  public Me(UserService userService) {
    this.userService = userService;
  }

  @DgsQuery(field = "me")
  public UserView getUser(@AuthenticationPrincipal String userId) throws UserNotFoundException {
    User user = userService.getUserById(UserId.of(userId));
    return UserView.fromDomain(user);
  }
}
