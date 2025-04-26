/**
 * @author Vanilson
 * @version 1.0
 * @since 2023-10-01
 */
package code.with.vanilson.minishop.presentation.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ErrorResponse is a class that represents the structure of an error response
 * returned by the API.
 */
@Data
@AllArgsConstructor
public class ErrorResponse {
    private int statusCode;
    private String message;
    private String timestamp;
}