package io.moira.application.user;

import io.moira.application.user.exception.UserAlreadyExistsException;
import io.moira.domain.user.User;
import io.moira.domain.user.UserRepository;
import io.moira.shared.domain.UseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@UseCase
public class RegisterUserUseCase {

  private static final Logger logger = LoggerFactory.getLogger(RegisterUserUseCase.class);

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public RegisterUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User execute(RegisterUserCommand command) throws UserAlreadyExistsException {
    if (userRepository.findByEmail(command.email()).isPresent()) {
      logger.debug("User with email {} already exists", command.email());
      throw new UserAlreadyExistsException();
    }

    String hashedPassword = passwordEncoder.encode(command.password());

    User user = User.create(command.email(), hashedPassword);
    user = userRepository.save(user);
    logger.debug("User {} has been successfully created", user.getId());

    return user;
  }
}
