package io.moira.interfaces.graphql.exception;

import graphql.GraphQLError;
import io.moira.shared.exception.MoiraException;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class MoiraExceptionHandler {

  @GraphQlExceptionHandler
  public GraphQLError handle(MoiraException e) {
    return GraphQLError.newError().errorType(e.errorType()).message(e.message()).build();
  }
}
