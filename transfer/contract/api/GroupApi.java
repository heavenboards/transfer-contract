package transfer.contract.api;

import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import transfer.contract.domain.group.GroupOperationResultTo;
import transfer.contract.domain.group.GroupTo;

/**
 * Api-клиент для взаимодействия с группами задач.
 */
@Headers({
    "Accept: application/json",
    "Content-Type: application/json"
})
public interface GroupApi {
    /**
     * Создать группу задач.
     *
     * @param group - to-модель группы задач
     * @return результат операции создания группы задач
     */
    @RequestLine("POST /api/v1/group")
    GroupOperationResultTo createGroup(final @RequestBody GroupTo group);
}
