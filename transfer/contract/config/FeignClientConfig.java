package transfer.contract.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import transfer.contract.api.AuthenticationApi;
import transfer.contract.api.ProjectApi;
import transfer.contract.api.UserApi;

import java.util.concurrent.TimeUnit;

/**
 * Конфигурация feign-клиентов.
 */
@Configuration
@RequiredArgsConstructor
public class FeignClientConfig {
    private final ObjectMapper objectMapper;
    private final ApplicationFeignErrorDecoder applicationFeignErrorDecoder;

    /**
     * Конфигурация AuthenticationApi.
     *
     * @param baseUrl - url
     * @return бин AuthenticationApi
     */
    @Bean
    public AuthenticationApi authenticationApi(
        @Value("${microservice.user-api.url}") String baseUrl
    ) {
        return Feign.builder()
            .client(new OkHttpClient())
            .encoder(new JacksonEncoder(objectMapper))
            .errorDecoder(applicationFeignErrorDecoder)
            .logger(new Slf4jLogger(UserApi.class))
            .logLevel(Logger.Level.FULL)
            .retryer(new Retryer.Default(0, 0, 0))
            .options(new Request.Options(15, TimeUnit.MINUTES, 15, TimeUnit.MINUTES, true))
            .target(AuthenticationApi.class, baseUrl);
    }

    /**
     * Конфигурация UserApi.
     *
     * @param baseUrl - url
     * @return бин UserApi
     */
    @Bean
    public UserApi userApi(
        @Value("${microservice.user-api.url}") String baseUrl
    ) {
        return Feign.builder()
            .client(new OkHttpClient())
            .encoder(new JacksonEncoder(objectMapper))
            .errorDecoder(applicationFeignErrorDecoder)
            .logger(new Slf4jLogger(UserApi.class))
            .logLevel(Logger.Level.FULL)
            .retryer(new Retryer.Default(0, 0, 0))
            .options(new Request.Options(15, TimeUnit.MINUTES, 15, TimeUnit.MINUTES, true))
            .target(UserApi.class, baseUrl);
    }

    /**
     * Конфигурация ProjectApi.
     *
     * @param baseUrl - url
     * @return бин ProjectApi
     */
    @Bean
    public ProjectApi projectApi(
        @Value("${microservice.project-api.url}") String baseUrl
    ) {
        return Feign.builder()
            .client(new OkHttpClient())
            .encoder(new JacksonEncoder(objectMapper))
            .errorDecoder(applicationFeignErrorDecoder)
            .logger(new Slf4jLogger(UserApi.class))
            .logLevel(Logger.Level.FULL)
            .retryer(new Retryer.Default(0, 0, 0))
            .options(new Request.Options(15, TimeUnit.MINUTES, 15, TimeUnit.MINUTES, true))
            .target(ProjectApi.class, baseUrl);
    }
}
