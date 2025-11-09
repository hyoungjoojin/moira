package io.moira.application.friend;

import io.moira.domain.friend.Friendship;
import io.moira.domain.friend.FriendshipRepository;
import io.moira.domain.user.UserId;
import io.moira.shared.domain.UseCase;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@UseCase
public class GetFriendsByUserUseCase {

  private final FriendshipRepository friendshipRepository;

  public GetFriendsByUserUseCase(FriendshipRepository friendshipRepository) {
    this.friendshipRepository = friendshipRepository;
  }

  public static record GetFriendsByUserQuery(UserId userId, Integer first, String after) {}

  public static record GetFriendsByUserResult(
      long totalCount, List<Friendship> friendships, boolean hasNext, boolean hasPrevious) {}

  @Transactional(readOnly = true)
  public GetFriendsByUserResult execute(GetFriendsByUserQuery query) {
    String cursor = query.after();
    int size = query.first() != null ? query.first() : 20;

    Page<Friendship> friendships =
        friendshipRepository.findAllAcceptedByUser(query.userId(), cursor, size);

    return new GetFriendsByUserResult(
        friendships.getTotalElements(),
        friendships.getContent(),
        friendships.hasNext(),
        friendships.hasPrevious());
  }
}
