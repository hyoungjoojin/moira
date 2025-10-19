package io.moira.infrastructure.persistence.notification.entity;

import io.moira.domain.notification.Notification;
import io.moira.domain.notification.NotificationType;
import io.moira.infrastructure.persistence.user.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class NotificationEntity {

  @Id
  @Column(name = "notification_id")
  protected UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  protected UserEntity user;

  @Enumerated(EnumType.STRING)
  @Column(name = "type", insertable = false, updatable = false)
  protected NotificationType type;

  @Column(name = "created_at")
  protected OffsetDateTime createdAt;

  public UserEntity getUser() {
    return user;
  }

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public abstract Notification toDomain();
}
