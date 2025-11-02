package io.moira.infrastructure.persistence.friend.entity;

import io.moira.domain.friend.Friendship;
import io.moira.domain.friend.FriendshipId;
import io.moira.domain.friend.FriendshipStatus;
import io.moira.domain.user.UserId;
import io.moira.infrastructure.persistence.user.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "friendships")
public class FriendshipEntity {

  @Id
  @Column(name = "friendship_id")
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_a_id", nullable = false)
  private UserEntity userA;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_b_id", nullable = false)
  private UserEntity userB;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private FriendshipStatus status;

  @Column(name = "created_at", nullable = false)
  private OffsetDateTime createdAt;

  @Column(name = "accepted_at", nullable = true)
  private OffsetDateTime acceptedAt;

  @Column(name = "rejected_at", nullable = true)
  private OffsetDateTime rejectedAt;

  public static FriendshipEntity of(UUID id) {
    FriendshipEntity entity = new FriendshipEntity();
    entity.id = id;
    return entity;
  }

  public Friendship toDomain() {
    FriendshipId id = new FriendshipId(this.id);
    return new Friendship(
        id,
        new UserId(userA.getId()),
        new UserId(userB.getId()),
        status,
        createdAt,
        Optional.ofNullable(acceptedAt),
        Optional.ofNullable(rejectedAt));
  }

  public static FriendshipEntity fromDomain(Friendship friendship) {
    FriendshipEntity entity = new FriendshipEntity();
    entity.id = friendship.getId().value();
    entity.userA = UserEntity.of(friendship.getUserA().value());
    entity.userB = UserEntity.of(friendship.getUserB().value());
    entity.status = friendship.getStatus();
    entity.createdAt = friendship.getCreatedAt();
    entity.acceptedAt = friendship.getAcceptedAt().orElse(null);
    entity.rejectedAt = friendship.getRejectedAt().orElse(null);

    return entity;
  }

  public UUID getId() {
    return id;
  }

  public UserEntity getUserA() {
    return userA;
  }

  public UserEntity getUserB() {
    return userB;
  }

  public FriendshipStatus getStatus() {
    return status;
  }

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public OffsetDateTime getAcceptedAt() {
    return acceptedAt;
  }

  public OffsetDateTime getRejectedAt() {
    return rejectedAt;
  }
}
