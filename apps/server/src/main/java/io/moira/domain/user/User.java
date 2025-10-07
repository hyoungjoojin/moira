package io.moira.domain.user;

import io.moira.shared.domain.AggregateRoot;
import java.time.OffsetDateTime;
import org.springframework.util.Assert;

public class User extends AggregateRoot<UserId> {

  private String email;
  private String hashedPassword;
  private OffsetDateTime createdAt;

  protected User(UserId id) {
    super(id);
  }

  public User(UserId id, String email, String hashedPassword, OffsetDateTime createdAt) {
    super(id);

    Assert.notNull(email, "The user's email must not be null");
    Assert.notNull(hashedPassword, "The user's password must not be null");

    this.email = email;
    this.hashedPassword = hashedPassword;
    this.createdAt = createdAt;
  }

  public static User create(String email, String hashedPassword) {
    User user = new User(UserId.create());
    user.email = email;
    user.hashedPassword = hashedPassword;
    user.createdAt = OffsetDateTime.now();
    return user;
  }

  public String getEmail() {
    return email;
  }

  public String getHashedPassword() {
    return hashedPassword;
  }

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }
}
