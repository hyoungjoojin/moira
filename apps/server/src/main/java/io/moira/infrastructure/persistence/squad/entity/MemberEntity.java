package io.moira.infrastructure.persistence.squad.entity;

import io.moira.domain.squad.SquadId;
import io.moira.domain.squad.member.Member;
import io.moira.domain.squad.member.MemberId;
import io.moira.domain.user.UserId;
import io.moira.infrastructure.persistence.user.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "members")
public class MemberEntity {

  @Id
  @Column(name = "member_id")
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "squad_id", nullable = false)
  private SquadEntity squad;

  @Column(name = "joined_at")
  private OffsetDateTime joinedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inviter_id", nullable = true)
  private UserEntity invitedBy;

  public Member toDomain() {
    MemberId id = new MemberId(this.id);
    SquadId squadId = new SquadId(this.squad.getId());
    UserId userId = new UserId(this.user.getId());

    Optional<UserId> invitedBy =
        Optional.ofNullable(this.invitedBy).map(UserEntity::getId).map(UserId::new);

    return new Member(id, squadId, userId, joinedAt, invitedBy);
  }

  public static MemberEntity fromDomain(Member member) {
    MemberEntity entity = new MemberEntity();
    entity.id = member.getId().value();
    entity.user = UserEntity.of(member.getUserId().value());
    entity.squad = SquadEntity.of(member.getSquadId().value());
    entity.invitedBy = member.getInvitedBy().map(UserId::value).map(UserEntity::of).orElse(null);

    return entity;
  }
}
