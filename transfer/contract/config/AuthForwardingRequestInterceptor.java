package transfer.contract.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Collection;
import java.util.Optional;

/**
 * Класс для передачи хедеров при взаимодействии микросервисов через feign-клиенты.
 */
@Slf4j
public class AuthForwardingRequestInterceptor implements RequestInterceptor {
    /**
     * Метод обогащения запроса хедером AUTHORIZATION.
     *
     * @param requestTemplate - запрос
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        Collection<String> headerTokens = requestTemplate.headers().get(HttpHeaders.AUTHORIZATION);
        if (headerTokens == null || headerTokens.isEmpty()) {
            String authorization = Optional.ofNullable(RequestContextHolder.getRequestAttributes())
                .map(ServletRequestAttributes.class::cast)
                .map(ServletRequestAttributes::getRequest)
                .map(req -> req.getHeader(HttpHeaders.AUTHORIZATION))
                .orElse(null);

            if (authorization != null) {
                requestTemplate.header(HttpHeaders.AUTHORIZATION, authorization);
            } else {
                log.error("No Authorization header found in current request context!");
            }
        }
    }
}
