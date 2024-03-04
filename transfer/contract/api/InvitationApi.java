package transfer.contract.api;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import transfer.contract.domain.invitation.InvitationOperationResultTo;
import transfer.contract.domain.invitation.InvitationTo;

import java.util.List;

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
     * Найти все приглашения, которые пришли этому пользователю в проекты.
     *
     * @return все найденные приглашения
     */
    @GetMapping(value = "/api/v1/invitation/received", produces = "application/json")
    List<InvitationTo> findAllReceivedInvitations();

    /**
     * Найти все приглашения, которые присылал этот пользователь другим пользователям.
     *
     * @return все найденные приглашения
     */
    @GetMapping(value = "/api/v1/invitation/sent", produces = "application/json")
    List<InvitationTo> findAllSentInvitations();

    /**
     * Запрос на создание приглашения пользователя в проект.
     *
     * @param invitation - to-модель приглашения пользователя в проект
     * @return результат создания приглашения
     */
    @PostMapping(value = "/api/v1/invitation", produces = "application/json")
    InvitationOperationResultTo createInvitation(final @RequestBody InvitationTo invitation);
}
