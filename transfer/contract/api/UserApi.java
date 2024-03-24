package transfer.contract.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;
import transfer.contract.domain.user.UserTo;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Api-клиент для сервиса пользователей.
 */
@Headers({
    "Accept: application/json",
    "Content-Type: application/json"
})
public interface UserApi {
    /**
     * Получение пользователя по username.
     *
     * @param username - username
     * @return найденный пользователь
     */
    @RequestLine("GET /api/v1/user/{username}")
    UserTo findUserByUsername(final @Param String username);

    /**
     * Получение списка пользователей по идентификаторам.
     *
     * @param ids - идентификаторы пользователей, которых мы ищем
     * @return to-модели найденных пользователей
     */
    @RequestLine("POST /api/v1/user")
    List<UserTo> findUsersByIds(final @RequestBody Set<UUID> ids);
}
