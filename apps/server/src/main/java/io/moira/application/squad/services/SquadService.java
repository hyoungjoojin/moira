package io.moira.application.squad.services;

import io.moira.application.squad.exception.SquadNotFoundException;
import io.moira.domain.squad.Squad;
import io.moira.domain.squad.SquadId;
import io.moira.domain.squad.SquadRepository;
import io.moira.domain.squad.invitation.Invitation;
import io.moira.domain.squad.invitation.InvitationId;
import io.moira.domain.squad.member.Member;
import io.moira.domain.squad.member.MemberId;
import io.moira.domain.squad.member.MemberRepository;
import io.moira.shared.domain.UseCase;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SquadService {

  private static final Logger logger = LoggerFactory.getLogger(SquadService.class);

  private final SquadRepository squadRepository;
  private final MemberRepository memberRepository;

  public SquadService(SquadRepository squadRepository, MemberRepository memberRepository) {
    this.squadRepository = squadRepository;
    this.memberRepository = memberRepository;
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

  @UseCase
  @Transactional(readOnly = true)
  public List<Member> getMembers(List<MemberId> ids) {
    return memberRepository.findBySquad(null);
  }

  @UseCase
  @Transactional(readOnly = true)
  public List<Member> getMembersInSquad(SquadId id) {
    return memberRepository.findBySquad(id);
  }

  @UseCase
  public Invitation getInvitation(InvitationId id) {
    return null;
  }

  @UseCase
  public List<Invitation> getAllInvitationsForSquad(SquadId id) {
    return null;
  }
}
