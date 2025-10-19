package io.moira.interfaces.graphql.dto;

import io.moira.domain.squad.member.Member;
import java.time.OffsetDateTime;

public record MemberView(String userId, OffsetDateTime joinedAt) {

  public static MemberView fromDomain(Member member) {
    return new MemberView(member.getUserId().toString(), member.getJoinedAt());
  }
}
