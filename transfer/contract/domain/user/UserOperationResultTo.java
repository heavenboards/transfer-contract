package transfer.contract.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import transfer.contract.domain.common.OperationStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Результат операции над пользователем.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserOperationResultTo {
    /**
     * Статус выполнения операции.
     */
    @Builder.Default
    private OperationStatus status = OperationStatus.OK;

    /**
     * Идентификатор пользователя, над которым была произведена операция.
     */
    private UUID userId;

    /**
     * Ошибки, возникшие в результате выполнения операции.
     */
    @Builder.Default
    private List<UserOperationErrorTo> errors = new ArrayList<>();

    /**
     * TO ошибки при операции над пользователем.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class UserOperationErrorTo {
        /**
         * Идентификатор сущности пользователя, у которого произошла ошибка при выполнении операции.
         */
        private UUID failedUserId;

        /**
         * Код ошибки при операции над пользователем.
         */
        private UserOperationErrorCode errorCode;
    }
}
