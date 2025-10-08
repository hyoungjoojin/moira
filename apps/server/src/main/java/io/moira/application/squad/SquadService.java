package io.moira.application.squad;

import io.moira.application.squad.exception.SquadNotFoundException;
import io.moira.domain.squad.Squad;
import io.moira.domain.squad.SquadId;
import io.moira.domain.squad.SquadRepository;
import io.moira.shared.domain.UseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SquadService {

  private static final Logger logger = LoggerFactory.getLogger(SquadService.class);

  private final SquadRepository squadRepository;

  public SquadService(SquadRepository squadRepository) {
    this.squadRepository = squadRepository;
  }

  @UseCase
  @Transactional(readOnly = true)
  public Squad getSquad(SquadId id) throws SquadNotFoundException {
    return squadRepository
        .findById(id)
        .orElseThrow(
            () -> {
              logger.debug("Could not find squad with ID {}", id);
              return new SquadNotFoundException();
            });
  }
}
