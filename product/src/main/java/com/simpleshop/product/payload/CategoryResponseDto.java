package com.simpleshop.product.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "CategoryResponseDto", description = "Category response data structure used for API operations")
public class CategoryResponseDto {

    @Schema(description = "Unique identifier for the category", example = "123", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Schema(description = "Name of the category", example = "AGD", required = true)
    private String name;

    @NotNull
    @Schema(description = "Indicates whether the category is enabled", example = "true", required = true)
    private Boolean enabled;

    @Schema(
            description = "Children of the category",
            example = "[{\"id\": 124, \"name\": \"Subcategory\", \"enabled\": true, \"children\": []}]"
    )
    private Set<CategoryResponseDto> children = new HashSet<>();

}