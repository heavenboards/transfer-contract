package transfer.contract.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.UUID;

/**
 * TO-модель пользователя.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with", toBuilder = true)
@Accessors(chain = true)
public class UserTo {
    /**
     * Идентификатор.
     */
    private UUID id;
}
