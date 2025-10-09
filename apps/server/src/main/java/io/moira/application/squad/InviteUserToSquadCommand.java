package io.moira.application.squad;

import io.moira.domain.squad.SquadId;
import io.moira.domain.user.UserId;

public record InviteUserToSquadCommand(UserId inviter, UserId invitee, SquadId squad) {}
