package transfer.contract.domain.task;

import lombok.AllArgsConstructor;

/**
 * Роль пользователя в задаче.
 */
@AllArgsConstructor
public enum TaskRole {
    /**
     * Разработчик.
     */
    DEVELOPER("Разработчик"),

    /**
     * Аналитик.
     */
    ANALYST("Аналитик"),

    /**
     * Тестировщик.
     */
    TESTER("Тестировщик"),

    /**
     * Девопс.
     */
    DEVOPS("Девопс");

    /**
     * Название роли.
     */
    @SuppressWarnings("unused")
    private final String name;
}
