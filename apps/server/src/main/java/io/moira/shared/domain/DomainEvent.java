package io.moira.shared.domain;

import org.springframework.context.ApplicationEvent;

public abstract class DomainEvent extends ApplicationEvent {

  public DomainEvent() {
    super(DomainEvent.class);
  }
}
