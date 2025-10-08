package io.moira.interfaces.graphql.squad.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import io.moira.interfaces.graphql.squad.dto.CreateSquadInput;

@DgsComponent
public class CreateSquadMutation {

  @DgsMutation(field = "createSquad")
  public void createSquad(@InputArgument CreateSquadInput input) {}
}
