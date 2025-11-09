package io.moira.interfaces.graphql.dto;

public record PageInfo(boolean hasNextPage, boolean hasPreviousPage, String endCursor) {}
