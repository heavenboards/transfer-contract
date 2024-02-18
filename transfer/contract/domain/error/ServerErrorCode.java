package transfer.contract.domain.error;

/**
 * Коды ошибок при запросах.
 */
public enum ServerErrorCode {
    /**
     * Имя пользователя уже существует.
     */
    USERNAME_ALREADY_EXIST,

    /**
     * Имя пользователя не найдено.
     */
    USERNAME_NOT_FOUND,

    /**
     * Неверный логин или пароль.
     */
    INVALID_USERNAME_PASSWORD,

    /**
     * Невалидный JWT-токен.
     */
    WRONG_JWT_TOKEN,

    /**
     * Не найдено обработчика для эндпоинта.
     */
    NO_HANDLER_FOUND,
}
