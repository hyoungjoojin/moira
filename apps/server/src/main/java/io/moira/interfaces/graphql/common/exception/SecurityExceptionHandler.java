package io.moira.interfaces.graphql.common.exception;

import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class SecurityExceptionHandler {

  @GraphQlExceptionHandler
  public GraphQLError handle(AuthenticationException e) {
    return GraphQLError.newError()
        .errorType(ErrorType.UNAUTHORIZED)
        .message(e.getMessage())
        .build();
  }

  @GraphQlExceptionHandler
  public GraphQLError handle(AccessDeniedException e) {
    return GraphQLError.newError().errorType(ErrorType.FORBIDDEN).message(e.getMessage()).build();
  }
}
