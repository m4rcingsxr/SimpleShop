package com.simpleshop.product.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "FieldValidationError", description = "Details about a field validation error")
public record FieldValidationError(

        @NotBlank(message = "Field name cannot be blank.")
        @Schema(description = "The name of the field that failed validation", example = "username", required = true)
        String field,

        @NotBlank(message = "Validation message cannot be blank.")
        @Schema(description = "The validation message describing the error", example = "must not be blank", required = true)
        String message
) {
}