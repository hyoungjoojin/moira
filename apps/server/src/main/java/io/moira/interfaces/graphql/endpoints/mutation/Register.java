package io.moira.interfaces.graphql.endpoints.mutation;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import io.moira.application.user.exception.UserAlreadyExistsException;
import io.moira.application.user.services.register.RegisterUserCommand;
import io.moira.application.user.services.register.RegisterUserUseCase;
import io.moira.domain.user.User;
import io.moira.interfaces.graphql.dto.UserView;

@DgsComponent
public class Register {

  private final RegisterUserUseCase registerUserUseCase;

  public Register(RegisterUserUseCase registerUserUseCase) {
    this.registerUserUseCase = registerUserUseCase;
  }

  @DgsMutation(field = "register")
  public UserView register(@InputArgument RegisterUserInput input)
      throws UserAlreadyExistsException {
    User user = registerUserUseCase.execute(input.toCommand());
    return UserView.fromDomain(user);
  }
}

record RegisterUserInput(String email, String password) {

  public RegisterUserCommand toCommand() {
    return new RegisterUserCommand(email, password);
  }
}
