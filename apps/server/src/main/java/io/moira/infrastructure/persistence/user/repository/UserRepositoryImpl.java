package io.moira.infrastructure.persistence.user.repository;

import io.moira.domain.user.User;
import io.moira.domain.user.UserId;
import io.moira.domain.user.UserRepository;
import io.moira.infrastructure.persistence.user.entity.UserEntity;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private final UserJpaRepository userJpaRepository;

  public UserRepositoryImpl(UserJpaRepository userJpaRepository) {
    this.userJpaRepository = userJpaRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<User> findById(UserId id) {
    return userJpaRepository.findById(id.value()).map(UserEntity::toDomain);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<User> findByEmail(String email) {
    return userJpaRepository.findByEmail(email).map(UserEntity::toDomain);
  }

  @Override
  @Transactional
  public void save(User user) {
    UserEntity entity = UserEntity.fromDomain(user);
    userJpaRepository.save(entity);
  }
}
