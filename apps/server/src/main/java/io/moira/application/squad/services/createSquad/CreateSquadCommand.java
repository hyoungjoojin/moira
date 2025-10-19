package io.moira.application.squad.services.createSquad;

import io.moira.domain.user.UserId;

public record CreateSquadCommand(UserId creator, String name) {}
