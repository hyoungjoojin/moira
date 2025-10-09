package io.moira.application.squad;

import io.moira.domain.user.UserId;

public record CreateSquadCommand(UserId creator, String name) {}
