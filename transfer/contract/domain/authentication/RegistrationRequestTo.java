package transfer.contract.domain.authentication;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
     * Длина от 4 до 20 символов, разрешены буквы (заглавные и прописные).
     * Разрешены цифры, разрешены "_" и ".", но не в начале или в конце.
     */
    @Pattern(regexp = "^(?=.{4,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$",
        message = "Некорректное имя пользователя")
    @NotNull(message = "Пустое имя пользователя")
    private String username;

    /**
     * Пароль.
     * Минимум 8 символов, минимум одна заглавная буква, минимум одна строчная.
     * Минимум одна цифра и минимум один специальный символ из "@$!%*?&".
     */
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        message = "Некорректный пароль")
    @NotNull(message = "Пустой пароль")
    private String password;

    /**
     * Имя.
     */
    @Pattern(regexp = "^[a-zA-Z\\\\s]{2,20}$", message = "Некорректное имя")
    @NotNull(message = "Пустое имя")
    private String firstName;

    /**
     * Фамилия.
     */
    @Pattern(regexp = "^[a-zA-Z\\\\s]{2,20}$", message = "Некорректная фамилия")
    @NotNull(message = "Пустая фамилия")
    private String lastName;
}
