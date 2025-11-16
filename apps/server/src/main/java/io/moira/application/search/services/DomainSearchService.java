package io.moira.application.search.services;

import io.moira.domain.search.SearchType;

interface DomainSearchService {

  SearchType type();

  SearchResult search(String query, int first, String after);
}
