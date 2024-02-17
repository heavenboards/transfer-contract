package transfer.contract.domain.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Ответ на аутентификацию / регистрацию.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder(toBuilder = true)
public class TokenResponseTo {
    /**
     * JWT-токен.
     */
    private String token;
}
