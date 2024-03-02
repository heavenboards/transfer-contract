package transfer.contract.api;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Api-клиент для взаимодействия с группами задач.
 */
@Headers({
    "Accept: application/json",
    "Content-Type: application/json"
})
@FeignClient(
    value = "group-api",
    url = "${microservice.task-api.url}"
)
public interface GroupApi {
}
