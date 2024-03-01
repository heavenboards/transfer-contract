package transfer.contract.api;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Api-клиент для сервиса досок.
 */
@Headers({
    "Accept: application/json",
    "Content-Type: application/json"
})
@FeignClient(
    value = "board-api",
    url = "${microservice.board-api.url}"
)
public interface BoardApi {
}
