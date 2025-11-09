package io.moira.interfaces.graphql.dto;

import java.util.List;

public record MessageConnection(int totalCount, List<MessageView> nodes, PageInfo pageInfo) {}
