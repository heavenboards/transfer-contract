package transfer.contract.api;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import transfer.contract.domain.board.BoardOperationResultTo;
import transfer.contract.domain.board.BoardTo;

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
    /**
     * Создание доски.
     *
     * @param board - to-модель создаваемой доски
     * @return результат операции создания
     */
    @PostMapping(value = "/api/v1/board", produces = "application/json")
    BoardOperationResultTo createBoard(final @RequestBody BoardTo board);
}
