package transfer.contract.domain.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import transfer.contract.domain.common.OperationStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Результат операции над доской.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BoardOperationResultTo {
    /**
     * Статус выполнения операции.
     */
    @Builder.Default
    private OperationStatus status = OperationStatus.OK;

    /**
     * Идентификатор доски, над которой была произведена операция.
     */
    private UUID boardId;

    /**
     * Ошибки, возникшие в результате выполнения операции.
     */
    @Builder.Default
    private List<BoardOperationErrorTo> errors = new ArrayList<>();

    /**
     * TO ошибки при операции над доской.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class BoardOperationErrorTo {
        /**
         * Идентификатор сущности проекта, у которого произошла ошибка при выполнении операции.
         */
        private UUID failedBoardId;

        /**
         * Код ошибки при операции над доской.
         */
        private BoardOperationErrorCode errorCode;
    }
}
