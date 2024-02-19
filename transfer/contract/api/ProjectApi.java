package transfer.contract.api;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import transfer.contract.domain.project.ProjectOperationResultTo;
import transfer.contract.domain.project.ProjectTo;

import java.util.List;

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
     * Получить все проекты пользователя.
     *
     * @return все проекты пользователя
     */
    @GetMapping(value = "/api/v1/project", produces = "application/json")
    List<ProjectTo> getAllProjects();

    /**
     * Создать проект.
     *
     * @param project - данные проекта.
     * @return результат операции создания
     */
    @PostMapping(value = "/api/v1/project", produces = "application/json")
    ProjectOperationResultTo createProject(final @RequestBody ProjectTo project);
}
