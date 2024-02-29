package transfer.contract.exception;

/**
 * Базовый код ошибки приложения.
 */
public enum BaseErrorCode {
    /**
     * Не найдено.
     */
    NOT_FOUND,

    /**
     * Некорректный JWT-токен в Authorization хедере.
     */
    WRONG_JWT_TOKEN,

    /**
     * Базовая код ошибки на сервере.
     */
    INTERNAL_ERROR,
}
