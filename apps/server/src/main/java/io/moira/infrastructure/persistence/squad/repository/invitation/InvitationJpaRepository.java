package io.moira.infrastructure.persistence.squad.repository.invitation;

import io.moira.infrastructure.persistence.squad.entity.InvitationEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationJpaRepository extends JpaRepository<InvitationEntity, UUID> {}
