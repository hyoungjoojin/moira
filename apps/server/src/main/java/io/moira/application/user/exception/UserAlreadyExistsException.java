package io.moira.application.user.exception;

import io.moira.shared.exception.MoiraException;
import org.springframework.graphql.execution.ErrorType;

public class UserAlreadyExistsException extends MoiraException {

  @Override
  public ErrorType errorType() {
    return ErrorType.BAD_REQUEST;
  }

  @Override
  public String message() {
    return "User already exists";
  }
}
