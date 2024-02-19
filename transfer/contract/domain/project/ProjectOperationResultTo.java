package transfer.contract.domain.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
     * Результат операции.
     */
    private OperationResult operationResult;
}
