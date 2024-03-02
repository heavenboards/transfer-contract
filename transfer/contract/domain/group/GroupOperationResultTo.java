package transfer.contract.domain.group;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import transfer.contract.domain.common.OperationStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Результат операции над группой задач.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class GroupOperationResultTo {
    /**
     * Статус выполнения операции.
     */
    @Builder.Default
    private OperationStatus status = OperationStatus.OK;

    /**
     * Идентификатор группы задач, над которой была произведена операция.
     */
    private UUID groupId;

    /**
     * Ошибки, возникшие в результате выполнения операции.
     */
    @Builder.Default
    private List<GroupOperationErrorTo> errors = new ArrayList<>();

    /**
     * TO ошибки при операции над группой задач.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class GroupOperationErrorTo {
        /**
         * Идентификатор сущности группы задач, у которой произошла ошибка при выполнении операции.
         */
        private UUID failedGroupId;

        /**
         * Код ошибки при операции над группой задач.
         */
        private GroupOperationErrorCode errorCode;
    }
}
