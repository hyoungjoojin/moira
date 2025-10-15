package io.moira.domain.notification;

import io.moira.domain.user.UserId;
import io.moira.shared.domain.DomainRepository;
import java.util.List;

public interface NotificationRepository extends DomainRepository<Notification, NotificationId> {

  public List<Notification> findAllByRecipient(UserId recipient);
}
