package io.moira.infrastructure.persistence.user.repository;

import io.moira.infrastructure.persistence.user.entity.UserEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

  Optional<UserEntity> findByEmail(String email);
}
