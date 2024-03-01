package transfer.contract.domain.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Данные для запроса на регистрацию.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RegistrationRequestTo {
    /**
     * Уникальное имя пользователя.
     */
    private String username;

    /**
     * Пароль.
     */
    private String password;

    /**
     * Имя.
     */
    private String firstName;

    /**
     * Фамилия.
     */
    private String lastName;
}
