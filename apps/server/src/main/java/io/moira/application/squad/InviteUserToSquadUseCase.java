package io.moira.application.squad;

import io.moira.domain.squad.Invitation;
import io.moira.domain.squad.InvitationRepository;
import io.moira.shared.domain.UseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@UseCase
public class InviteUserToSquadUseCase {

  private final InvitationRepository invitationRepository;

  public InviteUserToSquadUseCase(InvitationRepository invitationRepository) {
    this.invitationRepository = invitationRepository;
  }

  @Transactional
  public Invitation execute(InviteUserToSquadCommand command) {
    Invitation invitation =
        Invitation.create(command.inviter(), command.invitee(), command.squad());
    invitation = invitationRepository.save(invitation);
    return invitation;
  }
}
