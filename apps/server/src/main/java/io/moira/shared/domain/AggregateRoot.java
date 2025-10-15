package io.moira.shared.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.util.Assert;

public abstract class AggregateRoot<T> extends Entity<T> {

  private final List<DomainEvent> domainEvents = new ArrayList<>();

  protected AggregateRoot(T id) {
    super(id);
  }

  protected void registerEvent(DomainEvent event) {
    Assert.notNull(event, "Domain event must not be null");

    domainEvents.add(event);
  }

  public void publishEvents(ApplicationEventPublisher publisher) {
    domainEvents.forEach(publisher::publishEvent);
    domainEvents.clear();
  }
}
