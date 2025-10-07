package io.moira.infrastructure.persistence.user;

import io.moira.domain.user.User;
import io.moira.domain.user.UserId;

class UserEntityMapper {

  static User toDomain(UserEntity entity) {
    UserId id = new UserId(entity.getId());
    return new User(id, entity.getEmail(), entity.getCreatedAt());
  }

  static UserEntity toEntity(User user) {
    UserEntity entity = new UserEntity();
    entity.setId(user.getId().value());
    entity.setEmail(user.getEmail());
    entity.setCreatedAt(user.getCreatedAt());
    return entity;
  }
}
