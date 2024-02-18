package transfer.contract.handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import transfer.contract.domain.error.FieldValidationErrorTo;
import transfer.contract.domain.error.ServerErrorCode;
import transfer.contract.domain.error.ServerErrorTo;
import transfer.contract.domain.error.ValidationErrorTo;
import transfer.contract.exception.ServerException;

import java.util.ArrayList;
import java.util.List;

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
            .body(ServerErrorTo.of(exception.getErrorCode()));
    }

    /**
     * Обработка исключений при обращении на несуществующий эндпоинт.
     *
     * @return to с кодом ошибки
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
        NoHandlerFoundException.class,
        HttpRequestMethodNotSupportedException.class
    })
    public ServerErrorTo handleNoHandlerFoundException() {
        return ServerErrorTo.of(ServerErrorCode.NO_HANDLER_FOUND);
    }

    /**
     * Обработка исключений при невалидных данных в теле запроса.
     *
     * @param exception - исключение
     * @return to с ошибками по всем полям
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorTo handleValidationException(MethodArgumentNotValidException exception) {
        List<FieldValidationErrorTo> fieldErrors = new ArrayList<>();
        exception.getBindingResult().getAllErrors()
            .forEach((error) -> fieldErrors.add(FieldValidationErrorTo.builder()
                .fieldName(((FieldError) error).getField())
                .fieldError(error.getDefaultMessage())
                .build()));

        return ValidationErrorTo.of(fieldErrors);
    }
}
