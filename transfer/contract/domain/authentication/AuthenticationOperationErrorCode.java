package transfer.contract.domain.authentication;

/**
 * Код ошибки при операции регистрации / аутентификации.
 */
public enum AuthenticationOperationErrorCode {
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
    INVALID_USERNAME_PASSWORD
}
