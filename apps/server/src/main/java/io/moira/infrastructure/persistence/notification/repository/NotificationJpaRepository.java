package io.moira.infrastructure.persistence.notification.repository;

import io.moira.infrastructure.persistence.notification.entity.NotificationEntity;
import io.moira.infrastructure.persistence.user.entity.UserEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationJpaRepository extends JpaRepository<NotificationEntity, UUID> {

  public List<NotificationEntity> findAllByUser(UserEntity user);
}
