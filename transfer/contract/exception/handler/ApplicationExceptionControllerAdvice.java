package transfer.contract.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import transfer.contract.domain.validation.FieldValidationErrorTo;
import transfer.contract.domain.validation.ValidationErrorTo;
import transfer.contract.exception.ApplicationException;
import transfer.contract.exception.BaseErrorCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Обработчик исключений.
 */
@Slf4j
@RestControllerAdvice
public class ApplicationExceptionControllerAdvice {
    /**
     * Обработка базового исключения ApplicationException и его наследников.
     *
     * @param exception - исключение
     * @return ответ с данными об ошибке
     */
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ApplicationException> handle(ApplicationException exception) {
        ResponseEntity<ApplicationException> entity = Optional
            .ofNullable(AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class))
            .map(annotation -> ResponseEntity.status(annotation.code()))
            .orElseGet(() -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR))
            .body(exception);

        if (entity.getStatusCode().is4xxClientError()) {
            log.warn("Произошла клиентская ошибка: {}", exception.getMessage());
        }
        if (entity.getStatusCode().is5xxServerError()) {
            log.error("Произошла ошибка сервера: {}", exception.getMessage());
        }

        return entity;
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
    public ApplicationException handleNoHandlerFoundException() {
        return new ApplicationException(BaseErrorCode.NOT_FOUND,
            "Не найден обработчик для этого эндпоинта");
    }
}
