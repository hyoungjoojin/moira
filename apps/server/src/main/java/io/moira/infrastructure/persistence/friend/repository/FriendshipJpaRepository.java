package io.moira.infrastructure.persistence.friend.repository;

import io.moira.domain.friend.FriendshipStatus;
import io.moira.infrastructure.persistence.friend.entity.FriendshipEntity;
import io.moira.infrastructure.persistence.user.entity.UserEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface FriendshipJpaRepository extends JpaRepository<FriendshipEntity, UUID> {

  @Query(
      """
      SELECT
        f
      FROM
        FriendshipEntity f
      WHERE
        (f.userA = :user OR f.userB = :user)
        AND f.status = :status
        AND (:cursor IS NULL OR f.id > :cursor)
      """)
  Page<FriendshipEntity> findByUserAndStatus(
      UserEntity user, FriendshipStatus status, String cursor, Pageable pageable);

  Optional<FriendshipEntity> findByUserAOrUserB(UserEntity userA, UserEntity userB);
}
