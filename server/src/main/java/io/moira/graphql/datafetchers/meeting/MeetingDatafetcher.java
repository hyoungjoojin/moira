package io.moira.graphql.datafetchers.meeting;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import io.moira.codegen.DgsConstants;
import io.moira.codegen.types.Meeting;
import java.util.List;

@DgsComponent
public class MeetingDatafetcher {

  @DgsQuery(field = DgsConstants.QUERY.Meetings)
  public List<Meeting> meetings() {
    return List.of(new Meeting("1", "Meeting One"), new Meeting("2", "Meeting Two"));
  }
}
