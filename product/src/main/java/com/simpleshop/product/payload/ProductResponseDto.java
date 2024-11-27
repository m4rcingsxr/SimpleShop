package com.simpleshop.product.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ProductResponseDto", description = "Product response data structure used for API operations")
public class ProductResponseDto extends AbstractProductDto {

    @NotNull
    @Schema(description = "Category assigned to this product", required = true)
    private CategoryResponseDto category;

    @NotNull
    @Schema(description = "Brand assigned to this product", required = true)
    private BrandDto brand;

}
