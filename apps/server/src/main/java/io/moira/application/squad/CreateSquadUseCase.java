package io.moira.application.squad;

import io.moira.domain.squad.Member;
import io.moira.domain.squad.MemberRepository;
import io.moira.domain.squad.Squad;
import io.moira.domain.squad.SquadRepository;
import io.moira.shared.domain.UseCase;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@UseCase
public class CreateSquadUseCase {

  private static final Logger logger = LoggerFactory.getLogger(CreateSquadUseCase.class);

  private final SquadRepository squadRepository;
  private final MemberRepository memberRepository;

  public CreateSquadUseCase(SquadRepository squadRepository, MemberRepository memberRepository) {
    this.squadRepository = squadRepository;
    this.memberRepository = memberRepository;
  }

  @Transactional
  public Squad execute(CreateSquadCommand command) {
    Squad squad = Squad.create(command.creator(), command.name());
    squad = squadRepository.save(squad);
    logger.debug("Squad {} has been successfully created", squad.getId());

    Member member = Member.create(squad.getId(), command.creator(), Optional.empty());
    memberRepository.save(member);
    logger.debug("Inserted user {} into squad {}", command.creator(), squad.getId());

    return squad;
  }
}
