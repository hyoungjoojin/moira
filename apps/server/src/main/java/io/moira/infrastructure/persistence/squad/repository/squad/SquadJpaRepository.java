package io.moira.infrastructure.persistence.squad.repository.squad;

import io.moira.infrastructure.persistence.squad.entity.SquadEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SquadJpaRepository extends JpaRepository<SquadEntity, UUID> {}
