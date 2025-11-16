package io.moira.domain.friend;

import io.moira.domain.user.UserId;
import io.moira.shared.domain.AggregateRoot;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.springframework.util.Assert;

public class Friendship extends AggregateRoot<FriendshipId> {

  private UserId leftUser;
  private UserId rightUser;

  private FriendshipStatus status;

  private OffsetDateTime createdAt;
  private Optional<OffsetDateTime> acceptedAt;
  private Optional<OffsetDateTime> rejectedAt;

  private Friendship(FriendshipId id, UserId leftUser, UserId rightUser) {
    super(id);

    Assert.notNull(leftUser, "Left user ID must not be null");
    Assert.notNull(rightUser, "Right user ID must not be null");

    this.leftUser = leftUser;
    this.rightUser = rightUser;
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
    friendship.status = FriendshipStatus.REQUEST_PENDING;
    friendship.createdAt = OffsetDateTime.now();
    friendship.acceptedAt = Optional.empty();
    friendship.rejectedAt = Optional.empty();

    friendship.registerEvent(new FriendRequestCreatedEvent(userB, friendship.getId()));
    return friendship;
  }

  public static Friendship createNonFrienship(UserId userA, UserId userB) {
    Friendship friendship = new Friendship(FriendshipId.create(), userA, userB);
    friendship.status = FriendshipStatus.NOT_FRIENDS;
    friendship.createdAt = OffsetDateTime.now();
    friendship.acceptedAt = Optional.empty();
    friendship.rejectedAt = Optional.empty();
    return friendship;
  }

  public UserId getLeftUser() {
    return leftUser;
  }

  public UserId getRightUser() {
    return rightUser;
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

  public OffsetDateTime getFriendsSince() {
    if (status == FriendshipStatus.FRIENDS) {
      return acceptedAt.orElseThrow(
          () -> new IllegalStateException("AcceptedAt must be present when status is FRIENDS"));
    }

    return null;
  }

  public void updateStatus(FriendshipStatus newStatus) {
    Assert.notNull(newStatus, "Status must not be null");

    this.status = newStatus;
    if (newStatus == FriendshipStatus.FRIENDS) {
      this.acceptedAt = Optional.of(OffsetDateTime.now());
      this.rejectedAt = Optional.empty();
    } else if (newStatus == FriendshipStatus.NOT_FRIENDS) {
      this.rejectedAt = Optional.of(OffsetDateTime.now());
      this.acceptedAt = Optional.empty();
    }
  }
}
