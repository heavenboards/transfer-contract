package transfer.contract.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Клиентская ошибка.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
@JsonIgnoreProperties(value = {"cause", "stackTrace", "suppressed", "localizedMessage"})
@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, property = "type")
@Getter
public class ClientApplicationException extends ApplicationException {
    @JsonCreator
    public ClientApplicationException(@JsonProperty("errorCode") BaseErrorCode errorCode,
                                      @JsonProperty("message") String message) {
        super(errorCode, message);
    }
}
