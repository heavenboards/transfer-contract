package transfer.contract.domain.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Данные для запроса на аутентификацию.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AuthenticationRequestTo {
    /**
     * Уникальное имя пользователя.
     */
    private String username;

    /**
     * Пароль.
     */
    private String password;
}
