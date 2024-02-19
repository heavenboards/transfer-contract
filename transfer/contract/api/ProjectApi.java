package transfer.contract.api;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Api-клиент для сервиса проектов.
 */
@Headers({
    "Accept: application/json",
    "Content-Type: application/json"
})
@FeignClient(
    value = "project-api",
    url = "${microservice.project-api.url}"
)
public interface ProjectApi {
}
