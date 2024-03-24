package transfer.contract.api;

import feign.Headers;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;
import transfer.contract.domain.task.TaskOperationResultTo;
import transfer.contract.domain.task.TaskTo;

/**
 * Api-клиент для взаимодействия с задачами.
 */
@Headers({
    "Accept: application/json",
    "Content-Type: application/json"
})
public interface TaskApi {
    /**
     * Создать задачу.
     *
     * @param task - to-модель задачи
     * @return результат операции создания задачи
     */
    @RequestLine("POST /api/v1/task")
    TaskOperationResultTo createTask(final @RequestBody TaskTo task);
}
