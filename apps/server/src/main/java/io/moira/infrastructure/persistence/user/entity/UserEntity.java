package io.moira.infrastructure.persistence.user.entity;

import io.moira.domain.user.User;
import io.moira.domain.user.UserId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

  @Id
  @Column(name = "user_id")
  private UUID id;

  @Column(name = "email", unique = true, nullable = false)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "bio", length = 1024)
  private String bio;

  @Column(name = "created_at")
  private OffsetDateTime createdAt;

  protected UserEntity() {}

  public static UserEntity of(UUID id) {
    UserEntity entity = new UserEntity();
    entity.setId(id);
    return entity;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public User toDomain() {
    UserId id = new UserId(this.id);
    return new User(id, email, password, fullName, bio, createdAt);
  }

  public static UserEntity fromDomain(User user) {
    UserEntity entity = new UserEntity();
    entity.id = user.getId().value();
    entity.email = user.getEmail();
    entity.password = user.getHashedPassword();
    entity.fullName = user.getFullName();
    entity.bio = user.getBio();
    entity.createdAt = user.getCreatedAt();
    return entity;
  }
}
