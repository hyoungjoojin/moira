package io.moira.domain.friend;

import io.moira.domain.user.UserId;
import io.moira.shared.domain.AggregateRoot;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.springframework.util.Assert;

public class Friendship extends AggregateRoot<FriendshipId> {

  private UserId userA;
  private UserId userB;

  private FriendshipStatus status;

  private OffsetDateTime createdAt;
  private Optional<OffsetDateTime> acceptedAt;
  private Optional<OffsetDateTime> rejectedAt;

  private Friendship(FriendshipId id, UserId userA, UserId userB) {
    super(id);

    Assert.notNull(userA, "User A must not be null");
    Assert.notNull(userB, "User B must not be null");

    this.userA = userA;
    this.userB = userB;
  }

  public Friendship(
      FriendshipId id,
      UserId userA,
      UserId userB,
      FriendshipStatus status,
      OffsetDateTime createdAt,
      Optional<OffsetDateTime> acceptedAt,
      Optional<OffsetDateTime> rejectedAt) {
    this(id, userA, userB);
    this.status = status;
    this.createdAt = createdAt;
    this.acceptedAt = acceptedAt;
    this.rejectedAt = rejectedAt;
  }

  public static Friendship create(UserId userA, UserId userB) {
    Friendship friendship = new Friendship(FriendshipId.create(), userA, userB);
    friendship.status = FriendshipStatus.PENDING;
    friendship.createdAt = OffsetDateTime.now();
    friendship.acceptedAt = Optional.empty();
    friendship.rejectedAt = Optional.empty();

    friendship.registerEvent(new FriendRequestCreatedEvent(userB, friendship.getId()));
    return friendship;
  }

  public UserId getUserA() {
    return userA;
  }

  public UserId getUserB() {
    return userB;
  }

  public FriendshipStatus getStatus() {
    return status;
  }

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public Optional<OffsetDateTime> getAcceptedAt() {
    return acceptedAt;
  }

  public Optional<OffsetDateTime> getRejectedAt() {
    return rejectedAt;
  }
}
