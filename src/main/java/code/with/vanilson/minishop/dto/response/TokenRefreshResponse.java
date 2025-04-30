package code.with.vanilson.minishop.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * TokenRefreshResponse
 *
 * @author vamuhong
 * @version 1.0
 * @since 2025-04-29
 */
@Getter
@Setter
public class TokenRefreshResponse {
    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";

    public TokenRefreshResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

}