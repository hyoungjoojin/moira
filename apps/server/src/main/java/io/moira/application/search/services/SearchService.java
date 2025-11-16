package io.moira.application.search.services;

import io.moira.domain.search.SearchType;
import io.moira.domain.user.UserId;
import io.moira.shared.domain.UseCase;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

  private final Map<SearchType, DomainSearchService> searchServices;

  public SearchService(List<DomainSearchService> searchServices) {
    this.searchServices =
        searchServices.stream()
            .collect(Collectors.toMap(DomainSearchService::type, service -> service));
  }

  public static record SearchCommand(String query, int first, String after, SearchType type) {}

  @UseCase
  public SearchResult search(UserId requesterId, SearchCommand command) {
    return searchServices
        .get(command.type())
        .search(command.query(), command.first, command.after());
  }
}
