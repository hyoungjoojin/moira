package io.moira.interfaces.graphql.dto.search;

import io.moira.interfaces.graphql.dto.PageInfo;
import java.util.List;

public record SearchResultConnection(
    long userCount, List<SearchResultEdge> edges, PageInfo pageInfo) {}
