package transfer.contract.domain.project;

/**
 * Код ошибки при операции над проектом.
 */
public enum ProjectOperationErrorCode {
    /**
     * У пользователя уже есть проект с таким названием.
     */
    NAME_ALREADY_EXIST,

    /**
     * Пользователь пытается совершить операцию над проектом, в котором он не состоит.
     */
    YOU_ARE_NOT_A_MEMBER,
}
