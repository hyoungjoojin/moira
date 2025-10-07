package io.moira.interfaces.graphql.user.mutation;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import io.moira.application.user.RegisterUserCommand;
import io.moira.application.user.RegisterUserUseCase;
import io.moira.application.user.exception.UserAlreadyExistsException;
import io.moira.domain.user.User;
import io.moira.interfaces.graphql.user.dto.RegisterUserInput;
import io.moira.interfaces.graphql.user.dto.UserView;
import io.moira.interfaces.graphql.user.mapper.UserMapper;

@DgsComponent
public class RegisterUserMutation {

  private final RegisterUserUseCase registerUserUseCase;

  public RegisterUserMutation(RegisterUserUseCase registerUserUseCase) {
    this.registerUserUseCase = registerUserUseCase;
  }

  @DgsMutation(field = "register")
  public UserView register(@InputArgument RegisterUserInput input)
      throws UserAlreadyExistsException {
    RegisterUserCommand command = map(input);
    User user = registerUserUseCase.execute(command);
    return UserMapper.toView(user);
  }

  private RegisterUserCommand map(RegisterUserInput input) {
    return new RegisterUserCommand(input.email(), input.password());
  }
}
