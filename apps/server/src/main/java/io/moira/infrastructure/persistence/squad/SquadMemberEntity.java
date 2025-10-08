package io.moira.infrastructure.persistence.squad;

import io.moira.infrastructure.persistence.user.UserEntity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "squad_members")
public class SquadMemberEntity {

  @EmbeddedId private SquadMemberEntityId id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inviter_id", nullable = true)
  private UserEntity invitedBy;
}
