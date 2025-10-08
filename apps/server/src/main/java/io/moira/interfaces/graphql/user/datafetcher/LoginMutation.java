package io.moira.interfaces.graphql.user.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.context.DgsContext;
import com.netflix.graphql.dgs.internal.DgsWebMvcRequestData;
import io.moira.application.user.UserService;
import io.moira.application.user.exception.UserNotFoundException;
import io.moira.domain.user.User;
import io.moira.interfaces.graphql.user.dto.LoginInput;
import io.moira.interfaces.graphql.user.dto.UserView;
import io.moira.interfaces.graphql.user.mapper.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;

@DgsComponent
public class LoginMutation {

  private final UserService userService;

  public LoginMutation(UserService userService) {
    this.userService = userService;
  }

  @DgsMutation(field = "login")
  public UserView login(@InputArgument LoginInput input, DgsDataFetchingEnvironment dfe)
      throws UserNotFoundException {
    User user = userService.login(getHttpServletRequest(dfe), input.email(), input.password());
    return UserMapper.toView(user);
  }

  private HttpServletRequest getHttpServletRequest(DgsDataFetchingEnvironment dfe) {
    DgsWebMvcRequestData dgsWebMvcRequestData =
        (DgsWebMvcRequestData) DgsContext.getRequestData(dfe);
    ServletWebRequest servletWebRequest = (ServletWebRequest) dgsWebMvcRequestData.getWebRequest();
    HttpServletRequest httpServletRequest = servletWebRequest.getRequest();
    return httpServletRequest;
  }
}
