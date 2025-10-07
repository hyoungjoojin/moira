package io.moira.shared.domain;

public abstract class Entity<T> {

  protected final T id;

  protected Entity(T id) {
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
