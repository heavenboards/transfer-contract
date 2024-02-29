package transfer.contract.domain.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import transfer.contract.domain.common.OperationStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Результат операции над проектом.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProjectOperationResultTo {
    /**
     * Статус выполнения операции.
     */
    @Builder.Default
    private OperationStatus status = OperationStatus.OK;

    /**
     * Идентификатор сущности, над которой была произведена операция.
     */
    private UUID entityId;

    /**
     * Ошибки, возникшие в результате выполнения операции.
     */
    @Builder.Default
    private List<ProjectOperationErrorTo> errors = new ArrayList<>();

    /**
     * TO ошибки при операции над проектом.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class ProjectOperationErrorTo {
        /**
         * Идентификатор сущности проекта, у которого произошла ошибка при выполнении операции.
         */
        private UUID failedProjectId;

        /**
         * Код ошибки при операции над проектом.
         */
        private ProjectOperationErrorCode errorCode;
    }
}
