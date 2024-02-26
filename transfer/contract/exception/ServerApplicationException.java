package transfer.contract.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Ошибка сервера.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@JsonIgnoreProperties(value = {"cause", "stackTrace", "suppressed", "localizedMessage"})
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "type")
@Getter
public class ServerApplicationException extends ApplicationException {
    @JsonCreator
    public ServerApplicationException(@JsonProperty("errorCode") BaseErrorCode errorCode,
                                      @JsonProperty("message") String message) {
        super(errorCode, message);
    }
}
