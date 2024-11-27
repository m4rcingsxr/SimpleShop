package com.simpleshop.product.payload;

import com.simpleshop.product.model.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;
import java.util.stream.Collectors;

@Schema(name = "CategoryResponseDto", description = "Category response data structure used for API operations")
public record CategoryResponseDto(

        @Schema(description = "Unique identifier for the category", example = "123", accessMode = Schema.AccessMode.READ_ONLY)
        Long id,

        @NotBlank
        @Size(max = 255)
        @Schema(description = "Name of the category", example = "AGD", required = true)
        String name,

        @NotNull
        @Schema(description = "Indicates whether the category is enabled", example = "true", required = true)
        Boolean enabled,

        @Schema(
                description = "Children of the category",
                example = """
                        [
                            {
                                "id": 124,
                                "name": "washing machines",
                                "enabled": true,
                                "children": []
                            }
                        ]
                        """
        )
        Set<CategoryResponseDto> children
) {

    /**
     * Static factory method to map a Category entity to a CategoryResponseDto.
     *
     * @param category The Category entity to map.
     * @return The corresponding CategoryResponseDto.
     */
    public static CategoryResponseDto fromEntity(Category category) {
        return new CategoryResponseDto(
                category.getId(),
                category.getName(),
                category.getEnabled(),
                category.getChildren().stream()
                        .map(CategoryResponseDto::fromEntity)
                        .collect(Collectors.toSet()));
    }
}
