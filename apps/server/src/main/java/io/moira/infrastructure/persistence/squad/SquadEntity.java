package io.moira.infrastructure.persistence.squad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "squads")
public class SquadEntity {

  @Id
  @Column(name = "squad_id")
  private UUID id;

  @Column(name = "name", nullable = false)
  private String name;

  @OneToMany private List<SquadMemberEntity> members;

  @Column(name = "created_at")
  private OffsetDateTime createdAt;
}
