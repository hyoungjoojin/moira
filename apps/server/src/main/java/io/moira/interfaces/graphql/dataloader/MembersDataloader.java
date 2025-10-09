package io.moira.interfaces.graphql.dataloader;

import com.netflix.graphql.dgs.DgsDataLoader;
import io.moira.application.squad.SquadService;
import io.moira.domain.squad.Member;
import io.moira.domain.squad.SquadId;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import org.dataloader.BatchLoader;

@DgsDataLoader(name = "members")
public class MembersDataloader implements BatchLoader<SquadId, List<Member>> {

  private final SquadService squadService;

  public MembersDataloader(SquadService squadService) {
    this.squadService = squadService;
  }

  @Override
  public CompletionStage<List<List<Member>>> load(List<SquadId> squadIds) {
    return CompletableFuture.supplyAsync(
        () ->
            squadIds.stream()
                .map(squadId -> squadService.getMembersInSquad(squadId))
                .collect(Collectors.toList()));
  }
}
