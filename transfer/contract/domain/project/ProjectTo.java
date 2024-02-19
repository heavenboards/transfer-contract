package transfer.contract.domain.project;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
     * Не должно быть пустым, длина от 4 до 64 символов.
     */
    @NotNull(message = "Пустое имя")
    @Size(min = 4, max = 64, message = "Некорректная длина названия проекта.")
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
