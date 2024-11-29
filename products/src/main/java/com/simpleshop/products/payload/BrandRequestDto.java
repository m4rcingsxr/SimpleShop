package com.simpleshop.products.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(name = "BrandRequestDto", description = "Brand request data structure used for API operations")
public record BrandRequestDto(

        @NotBlank
        @Size(max = 255)
        @Schema(description = "Name of the brand", example = "Smartphone", required = true)
        String name

) {}