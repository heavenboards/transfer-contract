package transfer.contract.api;

import feign.Headers;
import heavenboards.user.service.user.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Api-клиент для сервиса пользователей.
 */
@Headers({
    "Accept: application/json",
    "Content-Type: application/json"
})
@FeignClient(
    value = "card-api",
    url = "${microservice.user-api.url}"
)
public interface UserApi {

    /**
     * Получение пользователя по username.
     *
     * @param username - username
     * @return найденный пользователь
     */
    @GetMapping(value = "/api/v1/user/{username}", produces = "application/json")
    UserEntity findUserById(@PathVariable String username);
}
