package com.simpleshop.product.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractProductDto {

    @Schema(description = "Unique identifier for the product", example = "123", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Schema(description = "Name of the product", example = "Smartphone", required = true)
    private String name;

    @NotBlank
    @Size(max = 255)
    @Schema(description = "Short description of the product", example = "A compact smartphone with excellent battery life.", required = true)
    private String shortDescription;

    @NotBlank
    @Size(max = 2550)
    @Schema(description = "Detailed description of the product", example = "This smartphone features a sleek design, powerful processor, and a high-resolution camera.", required = true)
    private String fullDescription;

    @NotNull
    @Schema(description = "Indicates whether the product is in stock", example = "true", required = true)
    private Boolean inStock;

    @NotNull
    @DecimalMin("0.01")
    @DecimalMax("50.0")
    @Schema(description = "Weight of the product in kilograms", example = "0.5", required = true, format = "float")
    private BigDecimal weight;

    @NotNull
    @DecimalMin("0.01")
    @DecimalMax("300.0")
    @Schema(description = "Width of the product in centimeters", example = "10.0", required = true, format = "float")
    private BigDecimal width;

    @NotNull
    @DecimalMin("0.01")
    @DecimalMax("200.0")
    @Schema(description = "Height of the product in centimeters", example = "15.0", required = true, format = "float")
    private BigDecimal height;

    @NotNull
    @DecimalMin("0.01")
    @DecimalMax("300.0")
    @Schema(description = "Length of the product in centimeters", example = "7.5", required = true, format = "float")
    private BigDecimal length;

    @NotNull
    @DecimalMin("0.01")
    @Schema(description = "Price of the product in the selected currency", example = "999.99", required = true, format = "float")
    private BigDecimal price;

    @NotNull
    @DecimalMin("0.01")
    @Schema(description = "Cost of the product in the selected currency", example = "750.00", required = true, format = "float")
    private BigDecimal cost;

    @DecimalMin("0.00")
    @DecimalMax("100.0")
    @Schema(description = "Discount percentage applied to the product (0-100)", example = "10.0", format = "float")
    private BigDecimal discountPercent;

}
