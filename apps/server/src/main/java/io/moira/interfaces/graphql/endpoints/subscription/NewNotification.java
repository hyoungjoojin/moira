package io.moira.interfaces.graphql.endpoints.subscription;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsSubscription;
import io.moira.domain.notification.Notification;
import io.moira.domain.notification.NotificationCreatedEvent;
import io.moira.interfaces.graphql.dto.NotificationView;
import org.reactivestreams.Publisher;
import org.springframework.context.ApplicationListener;
import reactor.core.publisher.Sinks;

@DgsComponent
public class NewNotification implements ApplicationListener<NotificationCreatedEvent> {

  private final Sinks.Many<Notification> sink = Sinks.many().multicast().onBackpressureBuffer();

  @DgsSubscription(field = "newNotification")
  public Publisher<NotificationView> send() {
    return sink.asFlux().map(NotificationView::fromDomain);
  }

  @Override
  public void onApplicationEvent(NotificationCreatedEvent event) {
    sink.tryEmitNext(event.getNotification());
  }
}
