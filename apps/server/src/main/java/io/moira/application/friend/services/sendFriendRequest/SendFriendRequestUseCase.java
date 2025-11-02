package io.moira.application.friend.services.sendFriendRequest;

import io.moira.application.friend.exception.FriendshipAlreadyExistsException;
import io.moira.domain.friend.Friendship;
import io.moira.domain.friend.FriendshipRepository;
import io.moira.shared.domain.UseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@UseCase
public class SendFriendRequestUseCase {

  private static final Logger logger = LoggerFactory.getLogger(SendFriendRequestUseCase.class);

  private final FriendshipRepository friendshipRepository;
  private final ApplicationEventPublisher eventPublisher;

  public SendFriendRequestUseCase(
      FriendshipRepository friendshipRepository, ApplicationEventPublisher eventPublisher) {
    this.friendshipRepository = friendshipRepository;
    this.eventPublisher = eventPublisher;
  }

  @Transactional
  public Friendship execute(SendFriendRequestCommand command)
      throws FriendshipAlreadyExistsException {
    if (friendshipRepository.findByUsers(command.requester(), command.receiver()).isPresent()) {
      throw new FriendshipAlreadyExistsException();
    }

    Friendship friendship = Friendship.create(command.requester(), command.receiver());
    friendshipRepository.save(friendship);
    friendship.publishEvents(eventPublisher);

    logger.debug(
        "User {} sent a friend request to user {}", command.requester(), command.receiver());
    return friendship;
  }
}
