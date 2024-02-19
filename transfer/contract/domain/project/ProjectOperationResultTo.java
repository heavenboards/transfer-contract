package transfer.contract.domain.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import transfer.contract.domain.common.OperationResult;

/**
 * Результат операции над проектом.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder(toBuilder = true)
public class ProjectOperationResultTo {
    /**
     * Вернуть результат ОК.
     *
     * @return результат ОК
     */
    public static ProjectOperationResultTo ok() {
        return ProjectOperationResultTo.builder()
            .operationResult(OperationResult.OK)
            .httpStatus(HttpStatus.OK)
            .build();
    }

    /**
     * Результат операции.
     */
    private OperationResult operationResult;

    /**
     * Http-статус операции.
     */
    @Builder.Default
    private HttpStatus httpStatus = HttpStatus.OK;

    /**
     * Код ошибки при операции над проектом.
     */
    private ProjectOperationErrorCode operationErrorCode;
}
