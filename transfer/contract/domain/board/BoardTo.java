package transfer.contract.domain.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import transfer.contract.domain.group.GroupTo;
import transfer.contract.domain.project.ProjectTo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * TO-класс для доски.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BoardTo {
    /**
     * Идентификатор.
     */
    private UUID id;

    /**
     * Название.
     */
    private String name;

    /**
     * Проект.
     */
    private ProjectTo project;

    /**
     * Вес позиции доски в проекте.
     * Нужен для определения порядка отображения досок в проекте на UI.
     */
    private Integer positionWeight;

    /**
     * Группы задач.
     */
    @Builder.Default
    private List<GroupTo> groups = new ArrayList<>();
}
