package io.moira.interfaces.graphql.datafetcher.query;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.DgsTypeResolver;
import io.moira.application.search.services.SearchResult;
import io.moira.application.search.services.SearchService;
import io.moira.application.search.services.SearchService.SearchCommand;
import io.moira.domain.search.SearchType;
import io.moira.domain.user.User;
import io.moira.domain.user.UserId;
import io.moira.interfaces.graphql.dataloader.UserDataLoader;
import io.moira.interfaces.graphql.dto.UserView;
import io.moira.interfaces.graphql.dto.search.SearchResultConnection;
import io.moira.interfaces.graphql.dto.search.SearchResultEdge;
import java.util.List;
import java.util.concurrent.CompletionStage;
import org.dataloader.DataLoader;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

record SearchInput(int first, String after, String query, SearchType type) {

  public SearchCommand toCommand() {
    return new SearchCommand(query, first, after, type);
  }
}

@DgsComponent
public class SearchDataFetcher {

  private final SearchService searchService;

  public SearchDataFetcher(SearchService searchService) {
    this.searchService = searchService;
  }

  @DgsQuery(field = "search")
  public SearchResultConnection search(@AuthenticationPrincipal String userId, SearchInput input) {
    SearchResult result = searchService.search(UserId.of(userId), input.toCommand());

    return new SearchResultConnection(
        result.page().getTotalElements(),
        result.page().getContent().stream()
            .map(item -> new SearchResultEdge(input.type(), item.id(), item.cursor()))
            .toList(),
        null);
  }

  @DgsData(parentType = "SearchResultConnection", field = "nodes")
  public CompletionStage<List<UserView>> nodes(DgsDataFetchingEnvironment dfe) {
    SearchResultConnection connection = dfe.getSource();

    DataLoader<UserId, User> dataloader = dfe.getDataLoader(UserDataLoader.class);

    return dataloader
        .loadMany(connection.edges().stream().map(edge -> UserId.of(edge.node())).toList())
        .thenApply(users -> users.stream().map(UserView::fromDomain).toList());
  }

  @DgsTypeResolver(name = "SearchResultItem")
  public String resolveType(Object item) {
    if (item instanceof UserView) {
      return "User";
    } else {
      throw new IllegalArgumentException("Unknown search type: " + item.getClass().getName());
    }
  }
}
