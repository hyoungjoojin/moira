package io.moira.shared.domain;

import java.util.Optional;

public interface DomainRepository<T extends AggregateRoot<I>, I> {

  Optional<T> findById(I id);

  void save(T entity);
}
