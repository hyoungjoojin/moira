package io.moira.graphql.datafetchers.meeting;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import io.moira.codegen.DgsConstants;
import io.moira.codegen.types.Meeting;

@DgsComponent
public class MeetingMutationDatafetcher {

  @DgsMutation(field = DgsConstants.MUTATION.CreateMeeting)
  public Meeting createMeeting(@InputArgument String title) {
    System.out.println(title);
    return new Meeting("id", title);
  }
}
