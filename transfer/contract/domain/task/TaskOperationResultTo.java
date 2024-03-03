package transfer.contract.domain.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import transfer.contract.domain.common.OperationStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Результат операции задачей.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TaskOperationResultTo {
    /**
     * Статус выполнения операции.
     */
    @Builder.Default
    private OperationStatus status = OperationStatus.OK;

    /**
     * Идентификатор задачи, над которой была произведена операция.
     */
    private UUID taskId;

    /**
     * Ошибки, возникшие в результате выполнения операции.
     */
    @Builder.Default
    private List<TaskOperationErrorTo> errors = new ArrayList<>();

    /**
     * TO ошибки при операции над задачей.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class TaskOperationErrorTo {
        /**
         * Идентификатор сущности задачи, у которой произошла ошибка при выполнении операции.
         */
        private UUID failedTaskId;

        /**
         * Код ошибки при операции над задачей.
         */
        private TaskOperationErrorCode errorCode;
    }
}
