package io.moira.interfaces.graphql.endpoints.mutation;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import io.moira.application.user.UserService;
import io.moira.domain.user.User;
import io.moira.interfaces.graphql.dto.UserView;
import io.moira.interfaces.graphql.utils.DgsUtils;
import jakarta.servlet.http.HttpServletRequest;

@DgsComponent
public class Login {

  private final UserService userService;

  public Login(UserService userService) {
    this.userService = userService;
  }

  @DgsMutation(field = "login")
  public UserView login(@InputArgument LoginInput input, DgsDataFetchingEnvironment dfe) {
    HttpServletRequest request = DgsUtils.getHttpServletRequest(dfe);
    User user = userService.login(request, input.email(), input.password());
    return UserView.fromDomain(user);
  }
}

record LoginInput(String email, String password) {}
