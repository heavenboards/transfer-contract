package transfer.contract.domain.task;


/**
 * Роль пользователя в задаче.
 */
public enum TaskRole {
    /**
     * Автор.
     */
    AUTHOR,

    /**
     * Исполнитель.
     */
    ASSIGNEE,

    /**
     * Разработчик.
     */
    DEVELOPER,

    /**
     * Проверяющий код
     */
    CODE_REVIEWER,

    /**
     * Аналитик.
     */
    ANALYST,

    /**
     * Тестировщик.
     */
    TESTER,

    /**
     * Девопс.
     */
    DEVOPS
}
