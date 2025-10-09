package io.moira.interfaces.graphql.dto;

import io.moira.domain.user.User;
import java.time.OffsetDateTime;

public record UserView(String id, String email, OffsetDateTime createdAt) {

  public static UserView fromDomain(User user) {
    return new UserView(user.getId().toString(), user.getEmail(), user.getCreatedAt());
  }
}
