package io.moira.application.user;

import io.moira.application.user.exception.UserNotFoundException;
import io.moira.domain.user.User;
import io.moira.domain.user.UserId;
import io.moira.domain.user.UserRepository;
import io.moira.shared.domain.UseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @UseCase
  @Transactional(readOnly = true)
  public User getUser(UserId id) throws UserNotFoundException {
    return userRepository
        .findById(id)
        .orElseThrow(
            () -> {
              logger.debug("Could not find user with ID {}", id);
              return new UserNotFoundException();
            });
  }
}
