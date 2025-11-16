package io.moira.interfaces.graphql.dto.search;

import io.moira.domain.search.SearchType;

public record SearchResultEdge(SearchType type, String node, String cursor) {}
