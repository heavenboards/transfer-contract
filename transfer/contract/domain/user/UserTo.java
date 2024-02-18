package transfer.contract.domain.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

/**
 * TO-класс для пользователя.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserTo implements UserDetails {
    /**
     * Уникальное имя пользователя.
     */
    private String username;

    /**
     * Хэшированный пароль.
     */
    @JsonIgnore
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
     * Истекло ли время действия аккаунта.
     */
    @Builder.Default
    private boolean accountNonExpired = true;

    /**
     * Заблокирован ли аккаунт.
     */
    @Builder.Default
    private boolean accountNonLocked = true;

    /**
     * Истекло ли время жизни credentials.
     */
    @Builder.Default
    private boolean credentialsNonExpired = true;

    /**
     * Активен ли аккаунт.
     */
    @Builder.Default
    private boolean enabled = true;

    /**
     * Дата и время создания.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private ZonedDateTime createdAt;

    /**
     * Дата и время последнего обновления.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private ZonedDateTime updatedAt;

    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
}
