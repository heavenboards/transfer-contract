package transfer.contract.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Роль пользователя.
 */
@Getter
@AllArgsConstructor
public enum UserRole {
    /**
     * Пользователь.
     */
    USER("Пользователь"),

    /**
     * Администратор.
     */
    ADMIN("Администратор");

    /**
     * Текстовое название роли.
     */
    @SuppressWarnings("unused")
    private final String name;
}
