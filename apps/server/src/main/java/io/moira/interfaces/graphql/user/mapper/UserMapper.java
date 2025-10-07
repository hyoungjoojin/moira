package io.moira.interfaces.graphql.user.mapper;

import io.moira.domain.user.User;
import io.moira.interfaces.graphql.user.dto.UserView;

public class UserMapper {

  public static UserView toView(User user) {
    return new UserView(user.getId().toString(), user.getEmail(), user.getCreatedAt());
  }
}
