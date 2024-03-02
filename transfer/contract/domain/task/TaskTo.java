package transfer.contract.domain.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import transfer.contract.domain.group.GroupTo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * TO-класс для задач.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TaskTo {
    /**
     * Идентификатор.
     */
    private UUID id;

    /**
     * Название.
     */
    private String name;

    /**
     * Описание.
     */
    private String description;

    /**
     * Группа.
     */
    private GroupTo group;

    /**
     * Порядковый номер задачи в группе.
     */
    @Builder.Default
    private Integer ordinalNumber = 1;

    /**
     * Участники задачи и их роли.
     */
    @Builder.Default
    private List<TaskParticipantTo> participants = new ArrayList<>();
}
