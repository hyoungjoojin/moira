package io.moira.interfaces.graphql.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import io.moira.domain.squad.Member;
import io.moira.domain.squad.SquadId;
import io.moira.interfaces.graphql.dataloader.MembersDataloader;
import io.moira.interfaces.graphql.dto.MemberView;
import io.moira.interfaces.graphql.dto.SquadView;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.dataloader.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DgsComponent
public class SquadDatafetcher {

  private static Logger logger = LoggerFactory.getLogger(SquadDatafetcher.class);

  @DgsData(parentType = "Squad", field = "members")
  public CompletableFuture<List<MemberView>> members(DgsDataFetchingEnvironment dfe) {
    Object source = dfe.getSource();

    if (!(source instanceof SquadView)) {
      throw new IllegalArgumentException();
    }

    SquadView squad = (SquadView) source;
    DataLoader<SquadId, List<Member>> dataloader = dfe.getDataLoader(MembersDataloader.class);

    logger.debug("Fetching members for squad {}", squad.id());
    return dataloader
        .load(SquadId.of(squad.id()))
        .thenApply(members -> members.stream().map(MemberView::fromDomain).toList());
  }
}
