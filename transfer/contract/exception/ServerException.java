package transfer.contract.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import transfer.contract.domain.error.ServerErrorCode;

/**
 * Базовое исключение.
 */
@Data
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(callSuper = true)
@Builder(toBuilder = true)
public class ServerException extends RuntimeException {
    /**
     * Код ошибки.
     */
    private final ServerErrorCode errorCode;

    /**
     * Какой http-код вернуть клиенту.
     */
    private final HttpStatus httpStatus;
}
