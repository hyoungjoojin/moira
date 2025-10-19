package io.moira.domain.squad.member;

import io.moira.domain.squad.SquadId;
import io.moira.shared.domain.DomainRepository;
import java.util.List;

public interface MemberRepository extends DomainRepository<Member, MemberId> {

  public List<Member> findBySquad(SquadId squadId);
}
