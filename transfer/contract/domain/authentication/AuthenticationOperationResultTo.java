package transfer.contract.domain.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import transfer.contract.domain.common.OperationStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Результат операции регистрации / аутентификации.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AuthenticationOperationResultTo {
    /**
     * Статус выполнения операции.
     */
    @Builder.Default
    private OperationStatus status = OperationStatus.OK;

    /**
     * Идентификатор пользователя, который зарегистрировался / аутентифицировался.
     */
    private UUID userId;

    /**
     * JWT-токен.
     */
    private String token;

    /**
     * Ошибки, возникшие в результате выполнения операции.
     */
    @Builder.Default
    private List<AuthenticationOperationErrorTo> errors = new ArrayList<>();

    /**
     * TO ошибки при операции регистрации / аутентификации.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class AuthenticationOperationErrorTo {
        /**
         * Идентификатор пользователя, у которого произошла ошибка при выполнении операции.
         */
        private UUID failedUserId;

        /**
         * Код ошибки при операции аутентификации / регистрации.
         */
        private AuthenticationOperationErrorCode errorCode;
    }
}
