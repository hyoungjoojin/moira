package io.moira.infrastructure.persistence.squad.repository.member;

import io.moira.domain.squad.SquadId;
import io.moira.domain.squad.member.Member;
import io.moira.domain.squad.member.MemberId;
import io.moira.domain.squad.member.MemberRepository;
import io.moira.infrastructure.persistence.squad.entity.MemberEntity;
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
  public void save(Member member) {
    MemberEntity memberEntity = MemberEntity.fromDomain(member);
    memberJpaRepository.save(memberEntity);
  }

  @Override
  public List<Member> findBySquad(SquadId squadId) {
    return memberJpaRepository.findBySquad(squadId.value()).stream()
        .map(MemberEntity::toDomain)
        .toList();
  }
}
