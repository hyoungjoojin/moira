package io.moira.infrastructure.persistence.squad;

import io.moira.infrastructure.persistence.user.UserEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class SquadMemberEntityId implements Serializable {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "squad_id", nullable = false)
  private SquadEntity squad;
}
