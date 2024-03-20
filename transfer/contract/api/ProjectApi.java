package transfer.contract.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
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
public interface ProjectApi {
    /**
     * Поиск проекта по идентификатору.
     *
     * @param id - идентификатор проекта
     * @return данные проекта
     */
    @RequestLine("GET /api/v1/project/{id}")
    ProjectTo findProjectById(final @Param UUID id);

    /**
     * Получить все проекты пользователя.
     *
     * @return все проекты пользователя
     */
    @RequestLine("GET /api/v1/project")
    List<ProjectTo> findUserProjects();

    /**
     * Создать проект.
     *
     * @param project - данные проекта.
     * @return результат операции создания
     */
    @RequestLine("POST /api/v1/project")
    ProjectOperationResultTo createProject(final @RequestBody ProjectTo project);

    /**
     * Обновить проект.
     *
     * @param project - данные проекта.
     * @return результат операции обновления
     */
    @RequestLine("PUT /api/v1/project")
    ProjectOperationResultTo updateProject(final @RequestBody ProjectTo project);
}
