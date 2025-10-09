package io.moira.domain.squad;

import io.moira.shared.domain.DomainRepository;
import java.util.List;

public interface MemberRepository extends DomainRepository<Member, MemberId> {

  public List<Member> findBySquad(SquadId squadId);
}
