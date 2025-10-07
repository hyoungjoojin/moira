package io.moira.shared.domain;

public abstract class ValueObject {

  public abstract Object value();

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }

    ValueObject other = (ValueObject) obj;

    Object thisValue = value(), thatValue = other.value();
    if (thisValue == null || thatValue == null) {
      return false;
    } else {
      return thisValue.equals(thatValue);
    }
  }

  @Override
  public String toString() {
    return value() == null ? "null" : value().toString();
  }
}
