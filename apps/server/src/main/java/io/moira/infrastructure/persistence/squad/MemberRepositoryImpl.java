package io.moira.infrastructure.persistence.squad;

import io.moira.domain.squad.Member;
import io.moira.domain.squad.MemberId;
import io.moira.domain.squad.MemberRepository;
import io.moira.domain.squad.SquadId;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

  private final MemberJpaRepository memberJpaRepository;

  public MemberRepositoryImpl(MemberJpaRepository memberJpaRepository) {
    this.memberJpaRepository = memberJpaRepository;
  }

  @Override
  public Optional<Member> findById(MemberId id) {
    return memberJpaRepository.findById(id.value()).map(MemberEntity::toDomain);
  }

  @Override
  public Member save(Member member) {
    MemberEntity memberEntity = MemberEntity.fromDomain(member);
    memberEntity = memberJpaRepository.save(memberEntity);
    return memberEntity.toDomain();
  }

  @Override
  public List<Member> findBySquad(SquadId squadId) {
    return memberJpaRepository.findBySquad(squadId.value()).stream()
        .map(MemberEntity::toDomain)
        .toList();
  }
}
