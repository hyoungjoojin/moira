package io.moira.interfaces.graphql.endpoints.subscription;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsSubscription;
import io.moira.domain.notification.NotificationId;
import java.time.Duration;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@DgsComponent
public class NotificationCreated {

  private final Sinks.Many<NotificationId> sink = Sinks.many().multicast().onBackpressureBuffer();

  @DgsSubscription(field = "notificationCreated")
  public Publisher<NotificationId> send() {
    return Flux.interval(Duration.ofSeconds(1)).map(t -> null);
  }

  public void publish(NotificationId id) {
    sink.tryEmitNext(id);
  }
}
