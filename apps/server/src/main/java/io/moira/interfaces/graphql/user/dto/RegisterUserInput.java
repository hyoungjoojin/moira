package io.moira.interfaces.graphql.user.dto;

import jakarta.validation.constraints.NotNull;

public record RegisterUserInput(@NotNull String email, @NotNull String password) {}
