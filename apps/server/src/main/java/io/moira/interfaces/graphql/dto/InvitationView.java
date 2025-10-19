package io.moira.interfaces.graphql.dto;

import io.moira.domain.squad.invitation.Invitation;

public record InvitationView(String inviterId, String inviteeId, String squadId) {

  public static InvitationView fromDomain(Invitation invitation) {
    throw new IllegalArgumentException();
  }
}
