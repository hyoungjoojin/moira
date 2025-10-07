package io.moira.interfaces.graphql.user.dto;

import java.time.OffsetDateTime;

public record UserView(String id, String email, OffsetDateTime createdAt) {}
