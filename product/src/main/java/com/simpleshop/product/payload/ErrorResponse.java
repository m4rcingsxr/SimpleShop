package com.simpleshop.product.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Schema(name = "ErrorResponse", description = "Details about an error returned by the API")
public record ErrorResponse(

        @Min(value = 100, message = "Status must be between 100 and 599.")
        @Max(value = 599, message = "Status must be between 100 and 599.")
        @Schema(description = "HTTP status code for the error (e.g., 400 for Bad Request)", example = "500", required = true)
        int status,

        @NotBlank(message = "Error type cannot be blank.")
        @Size(max = 100, message = "Error type must not exceed 100 characters.")
        @Schema(description = "Short description of the error type", example = "Internal server error", required = true)
        String error,

        @NotBlank(message = "Message cannot be blank.")
        @Size(max = 500, message = "Message must not exceed 500 characters.")
        @Schema(description = "Detailed explanation of the error", example = "Sorry internal server occurred, please contact administration or try again later", required = true)
        String message,

        @NotNull(message = "Timestamp cannot be null.")
        @Schema(description = "The timestamp of the error occurrence in ISO 8601 format", example = "2024-11-27T12:00:00", required = true, format = "date-time")
        LocalDateTime timestamp
) {
}