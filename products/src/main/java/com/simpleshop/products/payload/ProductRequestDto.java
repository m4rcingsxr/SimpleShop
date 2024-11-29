package com.simpleshop.products.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Schema(name = "ProductRequestDto", description = "Product request data structure used for API operations")
public record ProductRequestDto(

        @Schema(description = "Unique identifier for the products", example = "123", accessMode = Schema.AccessMode.READ_ONLY)
        Long id,

        @NotBlank
        @Size(max = 255)
        @Schema(description = "Name of the products", example = "Smartphone", required = true)
        String name,

        @NotBlank
        @Size(max = 255)
        @Schema(description = "Short description of the products", example = "A compact smartphone with excellent battery life.", required = true)
        String shortDescription,

        @NotBlank
        @Size(max = 2550)
        @Schema(description = "Detailed description of the products", example = "This smartphone features a sleek design, powerful processor, and a high-resolution camera.", required = true)
        String fullDescription,

        @NotNull
        @Schema(description = "Indicates whether the products is in stock", example = "true", required = true)
        Boolean inStock,

        @NotNull
        @DecimalMin("0.01")
        @DecimalMax("50.0")
        @Schema(description = "Weight of the products in kilograms", example = "0.5", required = true, format = "float")
        BigDecimal weight,

        @NotNull
        @DecimalMin("0.01")
        @DecimalMax("300.0")
        @Schema(description = "Width of the products in centimeters", example = "10.0", required = true, format = "float")
        BigDecimal width,

        @NotNull
        @DecimalMin("0.01")
        @DecimalMax("200.0")
        @Schema(description = "Height of the products in centimeters", example = "15.0", required = true, format = "float")
        BigDecimal height,

        @NotNull
        @DecimalMin("0.01")
        @DecimalMax("300.0")
        @Schema(description = "Length of the products in centimeters", example = "7.5", required = true, format = "float")
        BigDecimal length,

        @NotNull
        @DecimalMin("0.01")
        @Schema(description = "Price of the products in the selected currency", example = "999.99", required = true, format = "float")
        BigDecimal price,

        @NotNull
        @DecimalMin("0.01")
        @Schema(description = "Cost of the products in the selected currency", example = "750.00", required = true, format = "float")
        BigDecimal cost,

        @DecimalMin("0.00")
        @DecimalMax("100.0")
        @Schema(description = "Discount percentage applied to the products (0-100)", example = "10.0", format = "float")
        BigDecimal discountPercent,

        @NotNull
        @Positive
        @Schema(description = "Unique identifier for the associated Brand", example = "123", required = true)
        Long brandId,

        @NotNull
        @Positive
        @Schema(description = "Unique identifier for the associated Category", example = "456", required = true)
        Long categoryId

) {}