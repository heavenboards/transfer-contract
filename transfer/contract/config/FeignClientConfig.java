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
import transfer.contract.api.ProjectApi;

import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
public class FeignClientConfig {

    private final ObjectMapper objectMapper;

    @Bean
    public ProjectApi projectApi(@Value("${microservice.project-api.url}") String baseUrl) {
        return Feign.builder()
                .client(new OkHttpClient())
                .requestInterceptor(new AuthForwardingRequestInterceptor())
                .decoder(new JacksonDecoder(objectMapper))
                .encoder(new JacksonEncoder(objectMapper))
                .logger(new Slf4jLogger(ProjectApi.class))
                .logLevel(Logger.Level.NONE)
                .retryer(Retryer.NEVER_RETRY)
                .options(new Request.Options(15, TimeUnit.MINUTES, 15, TimeUnit.MINUTES, true))
                .target(ProjectApi.class, baseUrl);
    }
}
