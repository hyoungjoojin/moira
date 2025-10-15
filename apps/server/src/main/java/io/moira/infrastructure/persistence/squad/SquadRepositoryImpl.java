package io.moira.infrastructure.persistence.squad;

import io.moira.domain.squad.Squad;
import io.moira.domain.squad.SquadId;
import io.moira.domain.squad.SquadRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SquadRepositoryImpl implements SquadRepository {

  private final SquadJpaRepository squadJpaRepository;

  public SquadRepositoryImpl(SquadJpaRepository squadJpaRepository) {
    this.squadJpaRepository = squadJpaRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Squad> findById(SquadId id) {
    return squadJpaRepository.findById(id.value()).map(SquadEntity::toDomain);
  }

  @Override
  @Transactional
  public void save(Squad squad) {
    SquadEntity entity = SquadEntity.fromDomain(squad);
    squadJpaRepository.save(entity);
  }
}
