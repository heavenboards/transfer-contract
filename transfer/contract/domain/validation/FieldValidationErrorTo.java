package transfer.contract.domain.validation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TO-для ошибки валидации поля.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class FieldValidationErrorTo {
    /**
     * Название поля.
     */
    private String fieldName;

    /**
     * Тест ошибки по полю.
     */
    private String fieldError;
}
