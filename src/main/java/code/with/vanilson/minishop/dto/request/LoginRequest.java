package code.with.vanilson.minishop.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * LoginRequest
 *
 * @author vamuhong
 * @version 1.0
 * @since 2025-04-29
 */
@Getter
@Setter
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

}