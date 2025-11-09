package io.moira.interfaces.graphql.endpoints.query;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import io.moira.application.user.services.UserService;
import io.moira.interfaces.graphql.dto.UserView;
import java.util.List;

@DgsComponent
public class UsersQuery {

  private final UserService userService;

  public UsersQuery(UserService userService) {
    this.userService = userService;
  }

  @DgsQuery(field = "users")
  public List<UserView> getAllUsers() {
    return userService.getAllUsers().stream().map(UserView::fromDomain).toList();
  }
}
