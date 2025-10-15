package io.moira.infrastructure.persistence.notification;

import io.moira.infrastructure.persistence.user.UserEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationJpaRepository extends JpaRepository<NotificationEntity, UUID> {

  public List<NotificationEntity> findAllByUser(UserEntity user);
}
