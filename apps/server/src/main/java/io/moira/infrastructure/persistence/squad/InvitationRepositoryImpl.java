package io.moira.infrastructure.persistence.squad;

import io.moira.domain.squad.Invitation;
import io.moira.domain.squad.InvitationId;
import io.moira.domain.squad.InvitationRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InvitationRepositoryImpl implements InvitationRepository {

  private final InvitationJpaRepository invitationJpaRepository;

  public InvitationRepositoryImpl(InvitationJpaRepository invitationJpaRepository) {
    this.invitationJpaRepository = invitationJpaRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Invitation> findById(InvitationId id) {
    return invitationJpaRepository.findById(id.value()).map(InvitationEntity::toDomain);
  }

  @Override
  @Transactional
  public void save(Invitation invitation) {
    InvitationEntity invitationEntity = InvitationEntity.fromDomain(invitation);
    invitationJpaRepository.save(invitationEntity);
  }
}
