package io.moira.domain.squad.member;

import io.moira.domain.squad.SquadId;
import io.moira.domain.user.UserId;
import io.moira.shared.domain.AggregateRoot;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.springframework.util.Assert;

public class Member extends AggregateRoot<MemberId> {

  private SquadId squadId;
  private UserId userId;
  private OffsetDateTime joinedAt;
  private Optional<UserId> invitedBy;

  private Member(MemberId memberId, SquadId squadId, UserId userId) {
    super(memberId);

    Assert.notNull(squadId, "Squad ID must not be null");
    Assert.notNull(userId, "User ID must not be null");

    this.squadId = squadId;
    this.userId = userId;
  }

  public Member(
      MemberId memberId,
      SquadId squadId,
      UserId userId,
      OffsetDateTime joinedAt,
      Optional<UserId> invitedBy) {
    this(memberId, squadId, userId);

    this.joinedAt = joinedAt;
    this.invitedBy = invitedBy;
  }

  public static Member create(SquadId squadId, UserId userId, Optional<UserId> inviter) {
    Member member = new Member(MemberId.create(), squadId, userId);
    member.joinedAt = OffsetDateTime.now();
    member.invitedBy = inviter;

    return member;
  }

  public SquadId getSquadId() {
    return squadId;
  }

  public UserId getUserId() {
    return userId;
  }

  public OffsetDateTime getJoinedAt() {
    return joinedAt;
  }

  public Optional<UserId> getInvitedBy() {
    return invitedBy;
  }
}
