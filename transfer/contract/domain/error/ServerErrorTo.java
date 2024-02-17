package transfer.contract.domain.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TO-для информации о произошедшей ошибке.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ServerErrorTo {
    /**
     * Код ошибки.
     */
    private ServerErrorCode errorCode;
}
