package io.moira.shared.domain;

import org.springframework.util.Assert;

public abstract class Entity<T> {

  protected final T id;

  protected Entity(T id) {
    Assert.notNull(id, "The identifier of an entity must not be null");
    this.id = id;
  }

  public T getId() {
    return id;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }

    Entity<?> other = (Entity<?>) obj;

    if (id == null || other.id == null) {
      return false;
    } else {
      return id.equals(other.id);
    }
  }
}
