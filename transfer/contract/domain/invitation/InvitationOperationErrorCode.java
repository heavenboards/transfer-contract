package transfer.contract.domain.invitation;

/**
 * Код ошибки при операции над приглашением.
 */
public enum InvitationOperationErrorCode {
    /**
     * Приглашение этому пользователю в этот проект уже отправлено.
     */
    INVITATION_ALREADY_CREATED,

    /**
     * Пользователь пытается выполнить операцию не со своим приглашением.
     */
    THIS_IS_NOT_YOUR_INVITATION,
}
