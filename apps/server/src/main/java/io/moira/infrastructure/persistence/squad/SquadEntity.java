package io.moira.infrastructure.persistence.squad;

import io.moira.domain.squad.Squad;
import io.moira.domain.squad.SquadId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "squads")
public class SquadEntity {

  @Id
  @Column(name = "squad_id")
  private UUID id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "created_at")
  private OffsetDateTime createdAt;

  protected SquadEntity() {}

  public static SquadEntity of(UUID id) {
    SquadEntity entity = new SquadEntity();
    entity.id = id;
    return entity;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Squad toDomain() {
    SquadId id = new SquadId(this.id);
    return new Squad(id, name, createdAt);
  }

  public static SquadEntity fromDomain(Squad squad) {
    SquadEntity entity = new SquadEntity();
    entity.id = squad.getId().value();
    entity.name = squad.getName();
    entity.createdAt = squad.getCreatedAt();
    return entity;
  }
}
