package transfer.contract.domain.invitation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import transfer.contract.domain.common.OperationStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Результат операции над приглашением пользователя в проект.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class InvitationOperationResultTo {
    /**
     * Статус выполнения операции.
     */
    @Builder.Default
    private OperationStatus status = OperationStatus.OK;

    /**
     * Идентификатор приглашения, над которым была произведена операция.
     */
    private UUID invitationId;

    /**
     * Ошибки, возникшие в результате выполнения операции.
     */
    @Builder.Default
    private List<InvitationOperationErrorTo> errors = new ArrayList<>();

    /**
     * TO ошибки при операции над приглашением.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class InvitationOperationErrorTo {
        /**
         * Идентификатор сущности приглашения, у которого произошла ошибка при выполнении операции.
         */
        private UUID failedInvitationId;

        /**
         * Код ошибки при операции над приглашением.
         */
        private InvitationOperationErrorCode errorCode;
    }
}
