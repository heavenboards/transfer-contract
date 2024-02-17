package transfer.contract.handling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import transfer.contract.domain.error.ServerErrorTo;
import transfer.contract.exception.ServerException;

/**
 * Класс для обработки исключений при запросах.
 */
@RestControllerAdvice
public class ServerExceptionHandler {
    /**
     * Обработка базового исключения сервера.
     *
     * @param exception - исключение
     * @return to с кодом ошибки
     */
    @ExceptionHandler(ServerException.class)
    public ResponseEntity<?> handleSecurityException(ServerException exception) {
        return ResponseEntity
            .status(exception.getHttpStatus())
            .body(ServerErrorTo.builder()
                .errorCode(exception.getErrorCode())
                .build());
    }
}
