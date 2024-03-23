package transfer.contract.api;

import feign.Headers;
import feign.RequestLine;
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
public interface InvitationApi {
    /**
     * Найти все приглашения, которые пришли этому пользователю в проекты.
     *
     * @return все найденные приглашения
     */
    @RequestLine("GET /api/v1/invitation/received")
    List<InvitationTo> findAllReceivedInvitations();

    /**
     * Найти все приглашения, которые присылал этот пользователь другим пользователям.
     *
     * @return все найденные приглашения
     */
    @RequestLine("GET /api/v1/invitation/sent")
    List<InvitationTo> findAllSentInvitations();

    /**
     * Запрос на создание приглашения пользователя в проект.
     *
     * @param invitation - to-модель приглашения пользователя в проект
     * @return результат создания приглашения
     */
    @RequestLine("POST /api/v1/invitation")
    InvitationOperationResultTo createInvitation(final @RequestBody InvitationTo invitation);

    /**
     * Запрос на подтверждение приглашения пользователя в проект.
     *
     * @param invitation - to-модель приглашения пользователя в проект
     * @return результат подтверждения приглашения
     */
    @RequestLine("POST /api/v1/invitation/accept")
    InvitationOperationResultTo acceptInvitation(final @RequestBody InvitationTo invitation);

    /**
     * Запрос на отклонение приглашения пользователя в проект.
     *
     * @param invitation - to-модель приглашения пользователя в проект
     * @return результат отклонения приглашения
     */
    @RequestLine("POST /api/v1/invitation/reject")
    InvitationOperationResultTo rejectInvitation(final @RequestBody InvitationTo invitation);
}
