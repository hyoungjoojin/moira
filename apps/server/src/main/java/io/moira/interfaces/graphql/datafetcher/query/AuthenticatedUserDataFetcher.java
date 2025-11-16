package io.moira.interfaces.graphql.datafetcher.query;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import io.moira.application.user.exception.UserNotFoundException;
import io.moira.application.user.services.UserService;
import io.moira.domain.user.UserId;
import io.moira.interfaces.graphql.dto.UserView;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@DgsComponent
public class AuthenticatedUserDataFetcher {

  private final UserService userService;

  public AuthenticatedUserDataFetcher(UserService userService) {
    this.userService = userService;
  }

  @DgsQuery(field = "viewer")
  public UserView getAuthenticatedUser(@AuthenticationPrincipal String userId)
      throws UserNotFoundException {
    return UserView.fromDomain(userService.getUserById(UserId.of(userId)));
  }
}
