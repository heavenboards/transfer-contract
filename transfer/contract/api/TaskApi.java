package transfer.contract.api;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Api-клиент для сервиса задач.
 */
@Headers({
    "Accept: application/json",
    "Content-Type: application/json"
})
@FeignClient(
    value = "task-api",
    url = "${microservice.task-api.url}"
)
public interface TaskApi {
}
