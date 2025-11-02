package io.moira.application.friend.exception;

import io.moira.shared.exception.MoiraException;
import org.springframework.graphql.execution.ErrorType;

public class FriendshipAlreadyExistsException extends MoiraException {

  @Override
  public ErrorType errorType() {
    return ErrorType.BAD_REQUEST;
  }

  @Override
  public String message() {
    return "Friendship already exists";
  }
}
