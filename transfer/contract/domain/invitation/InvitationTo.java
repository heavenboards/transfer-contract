package transfer.contract.domain.invitation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import transfer.contract.domain.project.ProjectTo;
import transfer.contract.domain.user.UserTo;

import java.util.UUID;

/**
 * TO-класс для приглашения пользователя в проект.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class InvitationTo {
    /**
     * Идентификатор.
     */
    private UUID id;

    /**
     * Пользователь, которого приглашают в проект.
     */
    private UserTo invitedUser;

    /**
     * Пользователь, который отправил приглашение в проект.
     */
    private UserTo invitationSender;

    /**
     * Проект, в который приглашается пользователь.
     */
    private ProjectTo project;
}
