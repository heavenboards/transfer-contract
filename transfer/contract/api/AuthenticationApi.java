package transfer.contract.api;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import transfer.contract.domain.authentication.AuthenticationOperationResultTo;
import transfer.contract.domain.authentication.AuthenticationRequestTo;
import transfer.contract.domain.authentication.RegistrationRequestTo;

/**
 * Api-клиент для регистрации / аутентификации.
 */
@Headers({
    "Accept: application/json",
    "Content-Type: application/json"
})
@FeignClient(
    value = "authentication-api",
    url = "${microservice.user-api.url}"
)
public interface AuthenticationApi {
    /**
     * Запрос на регистрацию.
     *
     * @param request - данные для регистрации
     * @return результат операции с токеном
     */
    @PostMapping("/api/v1/auth/register")
    AuthenticationOperationResultTo register(
        final @RequestBody RegistrationRequestTo request
    );

    /**
     * Запрос на аутентификацию.
     *
     * @param request - данные для аутентификации
     * @return результат операции с токеном
     */
    @PostMapping("/api/v1/auth/authenticate")
    AuthenticationOperationResultTo authenticate(
        final @RequestBody AuthenticationRequestTo request
    );
}
