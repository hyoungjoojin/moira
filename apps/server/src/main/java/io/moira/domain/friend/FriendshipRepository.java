package io.moira.domain.friend;

import io.moira.domain.user.UserId;
import io.moira.shared.domain.DomainRepository;
import java.util.Optional;

public interface FriendshipRepository extends DomainRepository<Friendship, FriendshipId> {

  Optional<Friendship> findByUsers(UserId userA, UserId userB);
}
