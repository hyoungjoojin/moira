package io.moira.application.user.exception;

import io.moira.shared.exception.MoiraException;
import org.springframework.graphql.execution.ErrorType;

public class UserNotFoundException extends MoiraException {

  @Override
  public ErrorType errorType() {
    return ErrorType.NOT_FOUND;
  }

  @Override
  public String message() {
    return "User not found";
  }
}
