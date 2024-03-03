package transfer.contract.api;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import transfer.contract.domain.invitation.InvitationOperationResultTo;
import transfer.contract.domain.invitation.InvitationTo;

/**
 * Api-клиент для взаимодействия с приглашениями.
 */
@Headers({
    "Accept: application/json",
    "Content-Type: application/json"
})
@FeignClient(
    value = "invitation-api",
    url = "${microservice.user-api.url}"
)
public interface InvitationApi {
    /**
     * Запрос на создание приглашения пользователя в проект.
     *
     * @param invitation - to-модель приглашения пользователя в проект
     * @return результат создания приглашения
     */
    @PostMapping(value = "/api/v1/invitation", produces = "application/json")
    InvitationOperationResultTo createInvitation(final @RequestBody InvitationTo invitation);
}
