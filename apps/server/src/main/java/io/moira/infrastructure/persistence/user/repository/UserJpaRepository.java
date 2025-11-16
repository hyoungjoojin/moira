package io.moira.infrastructure.persistence.user.repository;

import io.moira.infrastructure.persistence.user.entity.UserEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

  Optional<UserEntity> findByEmail(String email);

  @Query(
      """
      SELECT u FROM UserEntity u
      WHERE u.email = :email
      AND (:cursor IS NULL OR u.id > CAST(:cursor AS uuid))
      ORDER BY u.id ASC
      """)
  Page<UserEntity> findAllByEmail(String email, String cursor, Pageable pageable);
}
