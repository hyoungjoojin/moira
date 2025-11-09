package io.moira.application.user.services;

import io.moira.application.user.exception.UserNotFoundException;
import io.moira.domain.user.User;
import io.moira.domain.user.UserId;
import io.moira.domain.user.UserRepository;
import io.moira.shared.domain.UseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  private final UserRepository userRepository;
  private final AuthenticationManager authenticationManager;

  public UserService(UserRepository userRepository, AuthenticationManager authenticationManager) {
    this.userRepository = userRepository;
    this.authenticationManager = authenticationManager;
  }

  @UseCase
  @Transactional(readOnly = true)
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @UseCase
  @Transactional(readOnly = true)
  public List<User> getUsersByIds(List<UserId> ids) {
    return ids.stream().map(id -> userRepository.findById(id).orElseThrow()).toList();
  }

  @UseCase
  @Transactional(readOnly = true)
  public User getUserById(UserId id) throws UserNotFoundException {
    return userRepository
        .findById(id)
        .orElseThrow(
            () -> {
              logger.debug("Could not find user with ID {}", id);
              return new UserNotFoundException();
            });
  }

  @UseCase
  @Transactional(readOnly = true)
  public User login(HttpServletRequest request, String email, String password) {
    User user =
        userRepository
            .findByEmail(email)
            .orElseThrow(
                () -> {
                  logger.debug("Could not find user with email {}", email);
                  return new BadCredentialsException("");
                });

    Authentication authentication =
        UsernamePasswordAuthenticationToken.authenticated(
            user.getUsername(), password, Collections.emptyList());
    authenticationManager.authenticate(authentication);

    SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
    securityContext.setAuthentication(authentication);
    SecurityContextHolder.setContext(securityContext);

    HttpSession session = request.getSession(true);
    session.setAttribute(
        HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);

    return user;
  }
}
