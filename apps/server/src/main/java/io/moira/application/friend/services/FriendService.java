package io.moira.application.friend.services;

import io.moira.application.friend.exception.FriendshipAlreadyExistsException;
import io.moira.domain.friend.Friendship;
import io.moira.domain.friend.FriendshipRepository;
import io.moira.domain.friend.FriendshipStatus;
import io.moira.domain.user.UserId;
import io.moira.shared.domain.UseCase;
import io.moira.shared.util.Pair;
import java.util.List;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendService {

  private final FriendshipRepository friendshipRepository;
  private final ApplicationEventPublisher eventPublisher;

  public FriendService(
      FriendshipRepository friendshipRepository, ApplicationEventPublisher eventPublisher) {
    this.friendshipRepository = friendshipRepository;
    this.eventPublisher = eventPublisher;
  }

  @UseCase
  @Transactional(readOnly = true)
  public List<Friendship> searchFriendships(List<Pair<UserId, UserId>> users) {
    return friendshipRepository.findAllByUsers(users);
  }

  @UseCase
  @Transactional
  public void sendFriendRequest(UserId from, UserId to) throws FriendshipAlreadyExistsException {
    if (from.equals(to)) {
      throw new IllegalArgumentException("Cannot send friend request to oneself");
    }

    if (friendshipRepository.findByUsers(from, to).isPresent()) {
      throw new FriendshipAlreadyExistsException();
    }

    Friendship friendship = Friendship.create(from, to);
    friendshipRepository.save(friendship);
    friendship.publishEvents(eventPublisher);
  }

  @UseCase
  @Transactional
  public void acceptFriendRequest(UserId from, UserId to) {
    Friendship friendship = friendshipRepository.findByUsers(from, to).orElseThrow();
    if (friendship.getStatus() != FriendshipStatus.REQUEST_PENDING) {
      throw new IllegalStateException("Friend request is not in a pending state");
    }

    if (!from.equals(friendship.getLeftUser())) {
      throw new AccessDeniedException("Only the recipient can accept the friend request");
    }

    friendship.updateStatus(FriendshipStatus.FRIENDS);
    friendshipRepository.save(friendship);
    friendship.publishEvents(eventPublisher);
  }

  @UseCase
  @Transactional
  public void rejectFriendRequest(UserId from, UserId to) {
    Friendship friendship = friendshipRepository.findByUsers(from, to).orElseThrow();
    if (friendship.getStatus() != FriendshipStatus.REQUEST_PENDING) {
      throw new IllegalStateException("Friend request is not in a pending state");
    }

    if (!from.equals(friendship.getLeftUser())) {
      throw new AccessDeniedException("Only the recipient can reject the friend request");
    }

    friendship.updateStatus(FriendshipStatus.NOT_FRIENDS);
    friendshipRepository.save(friendship);
    friendship.publishEvents(eventPublisher);
  }
}
