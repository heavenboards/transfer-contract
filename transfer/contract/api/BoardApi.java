package transfer.contract.api;

import feign.Headers;
import feign.RequestLine;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import transfer.contract.domain.board.BoardOperationResultTo;
import transfer.contract.domain.board.BoardTo;

import java.util.UUID;

/**
 * Api-клиент для сервиса досок.
 */
@Headers({
        "Accept: application/json",
        "Content-Type: application/json"
})
public interface BoardApi {
    /**
     * Поиск доски по идентификатору.
     *
     * @param id - идентификатор доски
     * @return данные доски
     */
    @RequestLine("GET /api/v1/board/{id}")
    BoardTo findBoardById(final @PathVariable UUID id);

    /**
     * Создание доски.
     *
     * @param board - to-модель создаваемой доски
     * @return результат операции создания
     */
    @RequestLine("POST /api/v1/board")
    BoardOperationResultTo createBoard(final @RequestBody BoardTo board);
}
