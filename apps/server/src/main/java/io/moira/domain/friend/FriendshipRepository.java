package io.moira.domain.friend;

import io.moira.domain.user.UserId;
import io.moira.shared.domain.DomainRepository;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface FriendshipRepository extends DomainRepository<Friendship, FriendshipId> {

  Page<Friendship> findAllAcceptedByUser(UserId userId, String cursor, int size);

  Optional<Friendship> findByUsers(UserId userA, UserId userB);
}
