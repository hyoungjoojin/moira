package io.moira.application.friend.services.sendFriendRequest;

import io.moira.domain.user.UserId;

public record SendFriendRequestCommand(UserId requester, UserId receiver) {}
