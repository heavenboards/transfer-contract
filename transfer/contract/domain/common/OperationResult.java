package transfer.contract.domain.common;

import lombok.AllArgsConstructor;

/**
 * Базовый енам для результата операции.
 */
@AllArgsConstructor
public enum OperationResult {
    /**
     * Успешно.
     */
    OK("Успешно"),

    /**
     * Ошибка.
     */
    FAILED("Ошибка");

    /**
     * Текстовое название.
     */
    @SuppressWarnings("unused")
    private final String name;
}
