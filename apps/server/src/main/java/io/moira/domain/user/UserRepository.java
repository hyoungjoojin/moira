package io.moira.domain.user;

import io.moira.shared.domain.DomainRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository extends DomainRepository<User, UserId> {

  Optional<User> findByEmail(String email);

  Page<User> findAllByEmail(String email, String cursor, Pageable pageable);

  List<User> findAll();
}
