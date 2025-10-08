package io.moira.application.squad.exception;

import io.moira.shared.exception.MoiraException;
import org.springframework.graphql.execution.ErrorType;

public class SquadNotFoundException extends MoiraException {

  @Override
  public ErrorType errorType() {
    return ErrorType.NOT_FOUND;
  }

  @Override
  public String message() {
    return "Squad not found";
  }
}
