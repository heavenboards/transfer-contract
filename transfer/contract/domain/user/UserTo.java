package transfer.contract.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * TO-модель пользователя.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Accessors(chain = true)
public class UserTo {
    /**
     * Идентификатор.
     */
    private UUID id;

    /**
     * Уникальное имя пользователя.
     */
    private String username;

    /**
     * Хэшированный пароль.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * Роль.
     */
    private UserRole role;

    /**
     * Имя.
     */
    private String firstName;

    /**
     * Фамилия.
     */
    private String lastName;

    /**
     * Признак "Удален" (для soft-delete).
     */
    private boolean deleted;

    /**
     * Дата и время создания.
     */
    private ZonedDateTime createdAt;

    /**
     * Дата и время последнего обновления.
     */
    private ZonedDateTime updatedAt;
}
