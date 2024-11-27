package com.simpleshop.product.payload;

import com.simpleshop.product.model.Brand;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(name = "BrandResponseDto", description = "Brand response data structure used for API operations")
public record BrandResponseDto(

        @Schema(description = "Unique identifier for the brand", example = "123", accessMode =
                Schema.AccessMode.READ_ONLY)
        Long id,

        @Schema(description = "Name of the brand", example = "Smartphone", required = true)
        String name

) {
    public static BrandResponseDto fromEntity(Brand brand) {
        return new BrandResponseDto(brand.getId(), brand.getName());
    }
}
