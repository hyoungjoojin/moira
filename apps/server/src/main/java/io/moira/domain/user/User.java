package io.moira.domain.user;

import io.moira.shared.domain.AggregateRoot;
import java.time.OffsetDateTime;

public class User extends AggregateRoot<UserId> {

  private String email;
  private OffsetDateTime createdAt;

  protected User(UserId id) {
    super(id);
  }

  public User(UserId id, String email, OffsetDateTime createdAt) {
    super(id);
    this.email = email;
    this.createdAt = createdAt;
  }

  public static User create(String email) {
    User user = new User(UserId.create());
    user.email = email;
    user.createdAt = OffsetDateTime.now();
    return user;
  }

  public String getEmail() {
    return email;
  }

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }
}
