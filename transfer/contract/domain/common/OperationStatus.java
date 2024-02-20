package transfer.contract.domain.common;

import lombok.AllArgsConstructor;

/**
 * Базовый енам для результата операции.
 */
@AllArgsConstructor
public enum OperationStatus {
    /**
     * Успешно.
     */
    OK,

    /**
     * Ошибка.
     */
    FAILED
}
