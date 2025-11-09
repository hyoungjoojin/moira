package io.moira.interfaces.graphql.dto.friend;

import io.moira.interfaces.graphql.dto.PageInfo;
import java.util.List;

public record FriendConnection(long totalCount, List<FriendView> edges, PageInfo pageInfo) {}
