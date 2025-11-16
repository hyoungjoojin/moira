package io.moira.application.search.services;

import io.moira.domain.search.SearchType;
import io.moira.domain.user.User;
import io.moira.domain.user.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

record UserSearchResult(Page<UserSearchResultItem> page) implements SearchResult {}

record UserSearchResultItem(String id, String cursor) implements SearchResult.Item {}

@Service
class UserSearchService implements DomainSearchService {

  private final UserRepository userRepository;

  public UserSearchService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public SearchType type() {
    return SearchType.USER;
  }

  @Override
  public SearchResult search(String query, int first, String after) {
    PageRequest pageRequest = PageRequest.of(0, (int) first);
    Page<User> users = userRepository.findAllByEmail(query, after, pageRequest);

    return new UserSearchResult(
        users.map(
            user ->
                new UserSearchResultItem(
                    user.getId().value().toString(), user.getId().value().toString())));
  }
}
