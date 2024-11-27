package com.simpleshop.product.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ErrorResponse", description = "Details about an error returned by the API")
public class ErrorResponse {

    @Min(100)
    @Max(599)
    @Schema(description = "HTTP status code for the error (e.g., 400 for Bad Request)", example = "500", required =
            true)
    private int status;

    @NotBlank
    @Size(max = 100)
    @Schema(description = "Short description of the error type", example = "Internal server error", required = true)
    private String error;

    @NotBlank
    @Size(max = 500)
    @Schema(description = "Detailed explanation of the error", example = "Sorry internal server occurred, please " +
            "contact with administration or try again later", required = true)
    private String message;

    @NotNull
    @Schema(description = "The timestamp of the error occurrence in ISO 8601 format", example = "2024-11-27T12:00:00"
            , required = true, format = "date-time")
    private LocalDateTime timestamp;
}
