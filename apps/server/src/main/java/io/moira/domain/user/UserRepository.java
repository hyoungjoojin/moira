package io.moira.domain.user;

import io.moira.shared.domain.DomainRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends DomainRepository<User, UserId> {

  Optional<User> findByEmail(String email);

  List<User> findAll();
}
