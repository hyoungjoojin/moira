package io.moira.interfaces.graphql.endpoints.mutation;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import kotlin.NotImplementedError;

@DgsComponent
public class InviteUserToSquad {

  @DgsMutation(field = "inviteUserToSquad")
  public void inviteUserToSquad() {
    throw new NotImplementedError();
  }
}
