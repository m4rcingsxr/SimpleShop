package com.simpleshop.products.payload;

import com.simpleshop.products.model.Brand;
import io.swagger.v3.oas.annotations.media.Schema;

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
