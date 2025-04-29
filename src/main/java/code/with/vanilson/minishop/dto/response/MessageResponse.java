package code.with.vanilson.minishop.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * MessageResponse
 *
 * @author vamuhong
 * @version 1.0
 * @since 2025-04-29
 */
@Getter
@Setter
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

}