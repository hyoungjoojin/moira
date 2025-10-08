package io.moira.infrastructure.persistence.squad;

import io.moira.domain.squad.Squad;
import io.moira.domain.squad.SquadId;
import io.moira.domain.squad.SquadRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class SquadRepositoryImpl implements SquadRepository {

  private final SquadJpaRepository squadJpaRepository;

  public SquadRepositoryImpl(SquadJpaRepository squadJpaRepository) {
    this.squadJpaRepository = squadJpaRepository;
  }

  @Override
  public Optional<Squad> findById(SquadId id) {
    return Optional.empty();
  }

  @Override
  public Squad save(Squad entity) {
    return null;
  }
}
