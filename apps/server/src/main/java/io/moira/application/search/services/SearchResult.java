package io.moira.application.search.services;

import org.springframework.data.domain.Page;

public interface SearchResult {

  public Page<? extends Item> page();

  public static interface Item {

    public String id();

    public String cursor();
  }
}
