package com.simpleshop.product.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ProductRequestDto", description = "Product request data structure used for API operations")
public class ProductDto extends AbstractProductDto {

    @NotNull
    @Positive
    @Schema(description = "Unique identifier for the associated Brand", example = "123", required = true)
    private Long brandId;

    @NotNull
    @Positive
    @Schema(description = "Unique identifier for the associated Category", example = "456", required = true)
    private Long categoryId;

}
