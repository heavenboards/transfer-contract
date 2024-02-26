package transfer.contract.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import transfer.contract.exception.ApplicationException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/**
 * Обработчик ошибок для Feign-клиентов.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ApplicationFeignErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper;

    @Override
    public Exception decode(String s, Response response) {
        String body = bodyToString(response.body());
        try {
            return objectMapper.readValue(body, ApplicationException.class);
        } catch (Exception ignored) {
            return new ApplicationException(null, "No message...");
        }
    }

    @SneakyThrows
    private static String bodyToString(Response.Body body) {
        if (body == null) {
            return null;
        }

        StringBuilder textBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(
            new InputStreamReader(body.asInputStream(), StandardCharsets.UTF_8)
        )) {
            int character;
            while ((character = reader.read()) != -1) {
                textBuilder.append((char) character);
            }
        }
        return textBuilder.toString();
    }
}
