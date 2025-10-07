package io.moira.shared.exception;

import org.springframework.graphql.execution.ErrorType;

public abstract class MoiraException extends Exception {

  public abstract ErrorType errorType();

  public abstract String message();
}
