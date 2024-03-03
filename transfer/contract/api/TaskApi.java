package transfer.contract.api;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
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
@FeignClient(
    value = "task-api",
    url = "${microservice.task-api.url}"
)
public interface TaskApi {
    /**
     * Создать задачу.
     *
     * @param task - to-модель задачи
     * @return результат операции создания задачи
     */
    @PostMapping(value = "/api/v1/task", produces = "application/json")
    TaskOperationResultTo createTask(final @RequestBody TaskTo task);
}
