package io.moira.infrastructure.persistence.notification.repository;

import io.moira.domain.notification.FriendRequestNotification;
import io.moira.domain.notification.Notification;
import io.moira.domain.notification.NotificationId;
import io.moira.domain.notification.NotificationRepository;
import io.moira.domain.notification.SquadInviteNotification;
import io.moira.domain.user.UserId;
import io.moira.infrastructure.persistence.notification.entity.FriendRequestNotificationEntity;
import io.moira.infrastructure.persistence.notification.entity.NotificationEntity;
import io.moira.infrastructure.persistence.notification.entity.SquadInviteNotificationEntity;
import io.moira.infrastructure.persistence.user.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {

  private final NotificationJpaRepository notificationJpaRepository;

  public NotificationRepositoryImpl(NotificationJpaRepository notificationJpaRepository) {
    this.notificationJpaRepository = notificationJpaRepository;
  }

  @Override
  public Optional<Notification> findById(NotificationId id) {
    return notificationJpaRepository.findById(id.value()).map(NotificationEntity::toDomain);
  }

  @Override
  public List<Notification> findAllByRecipient(UserId user) {
    return notificationJpaRepository.findAllByUser(UserEntity.of(user.value())).stream()
        .map(entity -> entity.toDomain())
        .toList();
  }

  @Override
  public void save(Notification notification) {
    NotificationEntity entity = null;

    switch (notification.getType()) {
      case SQUAD_INVITE:
        entity = SquadInviteNotificationEntity.fromDomain((SquadInviteNotification) notification);
        break;

      case FRIEND_REQUEST:
        entity =
            FriendRequestNotificationEntity.fromDomain((FriendRequestNotification) notification);
        break;

      default:
        throw new IllegalArgumentException();
    }

    notificationJpaRepository.save(entity);
  }
}
