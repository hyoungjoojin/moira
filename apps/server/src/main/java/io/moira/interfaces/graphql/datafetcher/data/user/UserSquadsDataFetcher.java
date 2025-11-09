package io.moira.interfaces.graphql.datafetcher.data.user;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import io.moira.application.squad.services.getSquadsByUser.GetSquadsByUserUseCase;
import io.moira.domain.user.UserId;
import io.moira.interfaces.graphql.dto.SquadView;
import io.moira.interfaces.graphql.dto.UserView;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DgsComponent
public class UserSquadsDataFetcher {

  private static final Logger logger = LoggerFactory.getLogger(UserDataFetcher.class);

  private final GetSquadsByUserUseCase getSquadsByUserUseCase;

  public UserSquadsDataFetcher(GetSquadsByUserUseCase getSquadsByUserUseCase) {
    this.getSquadsByUserUseCase = getSquadsByUserUseCase;
  }

  @DgsData(parentType = "User", field = "squads")
  public CompletableFuture<List<SquadView>> squads(DgsDataFetchingEnvironment dfe) {
    Object source = dfe.getSource();
    if (!(source instanceof UserView)) {
      throw new IllegalArgumentException("DataFetcher source is not of type UserView");
    }

    UserView user = (UserView) source;

    logger.debug("Fetching squads for user {}", user.id());
    return CompletableFuture.supplyAsync(
        () ->
            getSquadsByUserUseCase.execute(UserId.of(user.id())).stream()
                .map(SquadView::fromDomain)
                .toList());
  }
}
