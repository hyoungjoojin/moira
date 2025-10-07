package io.moira.application.user;

import io.moira.application.user.exception.UserAlreadyExistsException;
import io.moira.domain.user.User;
import io.moira.domain.user.UserRepository;
import io.moira.shared.domain.UseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@UseCase
public class RegisterUserUseCase {

  private static final Logger logger = LoggerFactory.getLogger(RegisterUserUseCase.class);

  private final UserRepository userRepository;

  public RegisterUserUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User execute(RegisterUserCommand command) throws UserAlreadyExistsException {
    if (userRepository.findByEmail(command.email()).isPresent()) {
      logger.debug("User with email {} already exists", command.email());
      throw new UserAlreadyExistsException();
    }

    User user = User.create(command.email());
    user = userRepository.save(user);
    return user;
  }
}
