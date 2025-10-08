package io.moira.interfaces.graphql.user.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import io.moira.application.user.UserService;
import io.moira.application.user.exception.UserNotFoundException;
import io.moira.domain.user.User;
import io.moira.domain.user.UserId;
import io.moira.interfaces.graphql.user.dto.UserView;
import io.moira.interfaces.graphql.user.mapper.UserMapper;
import org.springframework.security.access.prepost.PreAuthorize;

@DgsComponent
public class UserDatafetcher {

  private final UserService userService;

  public UserDatafetcher(UserService userService) {
    this.userService = userService;
  }

  @DgsQuery(field = "user")
  @PreAuthorize("isAuthenticated()")
  public UserView getUser(@InputArgument String id) throws UserNotFoundException {
    UserId userId = UserId.of(id);
    User user = userService.getUserById(userId);
    return UserMapper.toView(user);
  }
}
