package transfer.contract.api;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import transfer.contract.domain.project.ProjectOperationResultTo;
import transfer.contract.domain.project.ProjectTo;

import java.util.List;
import java.util.UUID;

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
    /**
     * Поиск проекта по идентификатору.
     *
     * @param id - идентификатор проекта
     * @return данные проекта
     */
    @GetMapping(value = "/api/v1/project/{id}", produces = "application/json")
    ProjectTo findProjectById(final @PathVariable UUID id);

    /**
     * Получить все проекты пользователя.
     *
     * @return все проекты пользователя
     */
    @GetMapping(value = "/api/v1/project", produces = "application/json")
    List<ProjectTo> findUserProjects();

    /**
     * Создать проект.
     *
     * @param project - данные проекта.
     * @return результат операции создания
     */
    @PostMapping(value = "/api/v1/project", produces = "application/json")
    ProjectOperationResultTo createProject(final @RequestBody ProjectTo project);

    /**
     * Обновить проект.
     *
     * @param project - данные проекта.
     * @return результат операции обновления
     */
    @PutMapping(value = "/api/v1/project", produces = "application/json")
    ProjectOperationResultTo updateProject(final @RequestBody ProjectTo project);
}
