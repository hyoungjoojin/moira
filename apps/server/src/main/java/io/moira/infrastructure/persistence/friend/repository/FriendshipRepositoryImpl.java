package io.moira.infrastructure.persistence.friend.repository;

import io.moira.domain.friend.Friendship;
import io.moira.domain.friend.FriendshipId;
import io.moira.domain.friend.FriendshipRepository;
import io.moira.domain.friend.FriendshipStatus;
import io.moira.domain.user.UserId;
import io.moira.infrastructure.persistence.friend.entity.FriendshipEntity;
import io.moira.infrastructure.persistence.user.entity.UserEntity;
import io.moira.infrastructure.persistence.user.repository.UserJpaRepository;
import io.moira.shared.util.Pair;
import java.util.List;
import java.util.Optional;
import org.jooq.DSLContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class FriendshipRepositoryImpl implements FriendshipRepository {

  private final DSLContext dslContext;
  private final FriendshipJpaRepository friendshipJpaRepository;
  private final UserJpaRepository userJpaRepository;

  public FriendshipRepositoryImpl(
      DSLContext dslContext,
      FriendshipJpaRepository friendshipJpaRepository,
      UserJpaRepository userJpaRepository) {
    this.dslContext = dslContext;
    this.friendshipJpaRepository = friendshipJpaRepository;
    this.userJpaRepository = userJpaRepository;
  }

  @Override
  public Optional<Friendship> findById(FriendshipId id) {
    return friendshipJpaRepository.findById(id.value()).map(FriendshipEntity::toDomain);
  }

  @Override
  public Page<Friendship> findAllAcceptedByUser(UserId userId, String cursor, int size) {
    UserEntity user = userJpaRepository.getReferenceById(userId.value());
    PageRequest pageRequest = PageRequest.of(0, size);

    Page<FriendshipEntity> result =
        friendshipJpaRepository.findByUserAndStatus(
            user, FriendshipStatus.FRIENDS, cursor, pageRequest);

    return result.map(FriendshipEntity::toDomain);
  }

  @Override
  public List<Friendship> findAllByUsers(List<Pair<UserId, UserId>> users) {
    return users.stream()
        .map(pair -> Pair.create(pair, findByUsers(pair.first(), pair.second())))
        .map(
            result ->
                result
                    .second()
                    .orElse(
                        Friendship.createNonFrienship(
                            result.first().first(), result.first().second())))
        .toList();
  }

  @Override
  public Optional<Friendship> findByUsers(UserId userA, UserId userB) {
    UserEntity userAEntity = userJpaRepository.getReferenceById(userA.value()),
        userBEntity = userJpaRepository.getReferenceById(userB.value());

    return friendshipJpaRepository
        .findByUserAOrUserB(userAEntity, userBEntity)
        .map(FriendshipEntity::toDomain);
  }

  @Override
  public void save(Friendship entity) {
    FriendshipEntity friendshipEntity = FriendshipEntity.fromDomain(entity);
    friendshipJpaRepository.save(friendshipEntity);
  }
}
