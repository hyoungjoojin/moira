package io.moira.shared.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
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

  @DomainEvents
  public Collection<DomainEvent> getDomainEvents() {
    return Collections.unmodifiableList(domainEvents);
  }

  @AfterDomainEventPublication
  protected void clearDomainEvents() {
    domainEvents.clear();
  }
}
