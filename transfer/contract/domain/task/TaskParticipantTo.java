package transfer.contract.domain.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import transfer.contract.domain.user.UserTo;

/**
 * TO-класс для участника задачи.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TaskParticipantTo {
    /**
     * Пользователь.
     */
    private UserTo user;

    /**
     * Задача.
     */
    private TaskTo task;

    /**
     * Роль пользователя в задаче.
     */
    private TaskRole role;
}
