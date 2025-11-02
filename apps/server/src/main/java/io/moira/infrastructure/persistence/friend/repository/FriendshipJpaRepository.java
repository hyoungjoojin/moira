package io.moira.infrastructure.persistence.friend.repository;

import io.moira.infrastructure.persistence.friend.entity.FriendshipEntity;
import io.moira.infrastructure.persistence.user.entity.UserEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

interface FriendshipJpaRepository extends JpaRepository<FriendshipEntity, UUID> {

  Optional<FriendshipEntity> findByUserAOrUserB(UserEntity userA, UserEntity userB);
}
