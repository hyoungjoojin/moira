package io.moira.shared.domain;

public abstract class AggregateRoot<T> extends Entity<T> {

  protected AggregateRoot(T id) {
    super(id);
  }
}
