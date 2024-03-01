package transfer.contract.domain.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import transfer.contract.domain.board.BoardTo;
import transfer.contract.domain.user.UserTo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * TO-класс для проекта.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProjectTo {
    /**
     * Идентификатор.
     */
    private UUID id;

    /**
     * Название.
     */
    private String name;

    /**
     * Участники проекта.
     */
    @Builder.Default
    private List<UserTo> users = new ArrayList<>();

    /**
     * Доски.
     */
    @Builder.Default
    private List<BoardTo> boards = new ArrayList<>();
}
