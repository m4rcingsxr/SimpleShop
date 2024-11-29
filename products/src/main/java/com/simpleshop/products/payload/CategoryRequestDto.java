package com.simpleshop.products.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(name = "CategoryRequestDto", description = "Category request data structure used for API operations")
public record CategoryRequestDto(
        @Schema(description = "Unique identifier for the category", example = "123", accessMode = Schema.AccessMode.READ_ONLY)
        Long id,

        @NotBlank
        @Size(max = 255)
        @Schema(description = "Name of the category", example = "AGD", required = true)
        String name,

        @NotNull
        @Schema(description = "Indicates whether the category is enabled", example = "true", required = true)
        Boolean enabled
) {}
