package transfer.contract.domain.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * TO для ошибки валидации тела JSON.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder(toBuilder = true)
public class ValidationErrorTo {
    /**
     * Ошибки по всем полям.
     */
    private List<FieldValidationErrorTo> fieldErrors;
}
