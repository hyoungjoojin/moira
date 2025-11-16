package io.moira.interfaces.graphql.dto.search;

import io.moira.domain.search.SearchType;

public record SearchResultView(String id, SearchType type) {}
