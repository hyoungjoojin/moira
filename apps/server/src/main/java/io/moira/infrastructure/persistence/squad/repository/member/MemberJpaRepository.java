package io.moira.infrastructure.persistence.squad.repository.member;

import io.moira.infrastructure.persistence.squad.entity.MemberEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, UUID> {

  @Query("SELECT m FROM MemberEntity m WHERE m.squad.id = :squadId")
  public List<MemberEntity> findBySquad(UUID squadId);
}
