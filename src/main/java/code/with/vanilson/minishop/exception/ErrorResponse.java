/**
 * @author Vanilson
 * @version 1.0
 * @since 2023-10-01
 */
package code.with.vanilson.minishop.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * ErrorResponse is a class that represents the structure of an error response
 * returned by the API.
 */
@Getter
@Setter
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ErrorResponse(int status, String message, String error, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.error = error;
        this.path = path;
    }

}