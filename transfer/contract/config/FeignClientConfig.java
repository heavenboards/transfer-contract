package transfer.contract.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import transfer.contract.api.AuthenticationApi;
import transfer.contract.api.BoardApi;
import transfer.contract.api.GroupApi;
import transfer.contract.api.InvitationApi;
import transfer.contract.api.ProjectApi;
import transfer.contract.api.TaskApi;
import transfer.contract.api.UserApi;

import java.util.concurrent.TimeUnit;

/**
 * Класс для создания сконфигурированных бинов feign-клиентов.
 */
@Configuration
@RequiredArgsConstructor
public class FeignClientConfig {
    /**
     * Класс для записи и конвертации объектов в JSON.
     */
    private final ObjectMapper objectMapper;

    /**
     * Метод для получения Feign клиента для API.
     *
     * @param apiClient класс, представляющий API клиента
     * @param baseUrl   базовый URL для API
     * @param <T>       тип API клиента
     * @return экземпляр Feign клиента для указанного API
     */
    private <T> T createFeignForApi(Class<T> apiClient, String baseUrl) {
        return Feign.builder()
            .client(new OkHttpClient())
            .requestInterceptor(new AuthForwardingRequestInterceptor())
            .decoder(new JacksonDecoder(objectMapper))
            .encoder(new JacksonEncoder(objectMapper))
            .logger(new Slf4jLogger(apiClient))
            .logLevel(Logger.Level.NONE)
            .retryer(Retryer.NEVER_RETRY)
            .options(new Request.Options(15, TimeUnit.MINUTES, 15, TimeUnit.MINUTES, true))
            .target(apiClient, baseUrl);
    }

    /**
     * Конфигурация feign-клиента для сервиса аутентификации {@link AuthenticationApi}.
     *
     * @param baseUrl - url сервиса аутентификации
     * @return сконфигурированный бин для взаимодействия с сервисом аутентификации
     */
    @Bean
    public AuthenticationApi authenticationApi(@Value("${microservice.user-api.url}") String baseUrl) {
        return Feign.builder()
            .client(new OkHttpClient())
            .decoder(new JacksonDecoder(objectMapper))
            .encoder(new JacksonEncoder(objectMapper))
            .logger(new Slf4jLogger(AuthenticationApi.class))
            .logLevel(Logger.Level.NONE)
            .retryer(Retryer.NEVER_RETRY)
            .options(new Request.Options(15, TimeUnit.MINUTES, 15, TimeUnit.MINUTES, true))
            .target(AuthenticationApi.class, baseUrl);
    }

    /**
     * Конфигурация feign-клиента для сервиса досок {@link BoardApi}.
     *
     * @param baseUrl - url сервиса досок
     * @return сконфигурированный бин для взаимодействия с сервисом досок
     */
    @Bean
    public BoardApi boardApi(@Value("${microservice.board-api.url}") String baseUrl) {
        return createFeignForApi(BoardApi.class, baseUrl);
    }

    /**
     * Конфигурация feign-клиента для сервиса групп {@link GroupApi}.
     *
     * @param baseUrl - url сервиса групп
     * @return сконфигурированный бин для взаимодействия с сервисом групп
     */
    @Bean
    public GroupApi groupApi(@Value("${microservice.task-api.url}") String baseUrl) {
        return createFeignForApi(GroupApi.class, baseUrl);
    }

    /**
     * Конфигурация feign-клиента для сервиса приглашений {@link InvitationApi}.
     *
     * @param baseUrl - url сервиса приглашений
     * @return сконфигурированный бин для взаимодействия с сервисом приглашений
     */
    @Bean
    public InvitationApi invitationApi(@Value("${microservice.user-api.url}") String baseUrl) {
        return createFeignForApi(InvitationApi.class, baseUrl);
    }

    /**
     * Конфигурация feign-клиента для сервиса проектов {@link ProjectApi}.
     *
     * @param baseUrl - url сервиса проектов
     * @return сконфигурированный бин для взаимодействия с сервисом проектов
     */
    @Bean
    public ProjectApi projectApi(@Value("${microservice.project-api.url}") String baseUrl) {
        return createFeignForApi(ProjectApi.class, baseUrl);
    }

    /**
     * Конфигурация feign-клиента для сервиса задач {@link TaskApi}.
     *
     * @param baseUrl - url сервиса задач
     * @return сконфигурированный бин для взаимодействия с сервисом задач
     */
    @Bean
    public TaskApi taskApi(@Value("${microservice.task-api.url}") String baseUrl) {
        return createFeignForApi(TaskApi.class, baseUrl);
    }

    /**
     * Конфигурация feign-клиента для сервиса пользователей {@link UserApi}.
     *
     * @param baseUrl - url сервиса пользователей
     * @return сконфигурированный бин для взаимодействия с сервисом пользователей
     */
    @Bean
    public UserApi userApi(@Value("${microservice.user-api.url}") String baseUrl) {
        return Feign.builder()
            .client(new OkHttpClient())
            .decoder(new JacksonDecoder(objectMapper))
            .encoder(new JacksonEncoder(objectMapper))
            .logger(new Slf4jLogger(UserApi.class))
            .logLevel(Logger.Level.NONE)
            .retryer(Retryer.NEVER_RETRY)
            .options(new Request.Options(15, TimeUnit.MINUTES, 15, TimeUnit.MINUTES, true))
            .target(UserApi.class, baseUrl);
    }
}
