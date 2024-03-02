package transfer.contract.domain.group;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import transfer.contract.domain.board.BoardTo;
import transfer.contract.domain.task.TaskTo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * TO-класс для группы задач.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class GroupTo {
    /**
     * Идентификатор.
     */
    private UUID id;

    /**
     * Название.
     */
    private String name;

    /**
     * Доска.
     */
    private BoardTo board;

    /**
     * Вес позиции группы задач на доске.
     * Нужен для определения порядка отображения групп на доске на UI.
     */
    private Integer positionWeight;

    /**
     * Задачи.
     */
    @Builder.Default
    private List<TaskTo> tasks = new ArrayList<>();
}
