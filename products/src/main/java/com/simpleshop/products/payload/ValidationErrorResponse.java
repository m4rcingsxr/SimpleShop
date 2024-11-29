package com.simpleshop.products.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;


@Schema(name = "ValidationErrorResponse", description = "Details about an error returned by the API")
public record ValidationErrorResponse(

        @Min(value = 100, message = "Status must be between 100 and 599.")
        @Max(value = 599, message = "Status must be between 100 and 599.")
        @Schema(description = "HTTP status code for the error (e.g., 400 for Bad Request)", example = "400", required = true)
        int status,

        @NotBlank(message = "Error type cannot be blank.")
        @Size(max = 100, message = "Error type must not exceed 100 characters.")
        @Schema(description = "Short description of the error type", example = "Bad Request", required = true)
        String error,

        @NotBlank(message = "Message cannot be blank.")
        @Size(max = 500, message = "Message must not exceed 500 characters.")
        @Schema(description = "Detailed explanation of the error", example = "Error due to malformed syntax", required = true)
        String message,

        @NotNull(message = "Timestamp cannot be null.")
        @Schema(description = "The timestamp of the error occurrence in ISO 8601 format", example = "2024-11-27T12:00:00", required = true, format = "date-time")
        LocalDateTime timestamp,

        @NotEmpty(message = "Validation errors cannot be empty.")
        @Schema(description = "Details about the fields that failed validation")
        List<@Valid FieldValidationError> validationErrors
) {
    /**
     * Static factory method to create ValidationErrorResponse from a Throwable and a pre-constructed list of field errors.
     *
     * @param throwable           The exception that occurred.
     * @param fieldValidationErrors List of field validation errors.
     * @return                    An instance of ValidationErrorResponse.
     */
    public static ValidationErrorResponse fromThrowable(
            Throwable throwable,
            List<FieldValidationError> fieldValidationErrors
    ) {
        return new ValidationErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                throwable.getMessage(),
                LocalDateTime.now(),
                fieldValidationErrors
        );
    }
}
