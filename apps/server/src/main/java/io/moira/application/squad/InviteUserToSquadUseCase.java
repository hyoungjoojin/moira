package io.moira.application.squad;

import io.moira.domain.squad.Invitation;
import io.moira.domain.squad.InvitationRepository;
import io.moira.shared.domain.UseCase;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@UseCase
public class InviteUserToSquadUseCase {

  private final InvitationRepository invitationRepository;
  private final ApplicationEventPublisher eventPublisher;

  public InviteUserToSquadUseCase(
      InvitationRepository invitationRepository, ApplicationEventPublisher eventPublisher) {
    this.invitationRepository = invitationRepository;
    this.eventPublisher = eventPublisher;
  }

  @Transactional
  public Invitation execute(InviteUserToSquadCommand command) {
    Invitation invitation =
        Invitation.create(command.inviter(), command.invitee(), command.squad());
    invitationRepository.save(invitation);
    invitation.publishEvents(eventPublisher);

    return invitation;
  }
}
