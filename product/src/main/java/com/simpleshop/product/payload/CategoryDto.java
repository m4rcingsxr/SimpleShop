package com.simpleshop.product.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto extends AbstractAuditEntity {

    @Schema(description = "Unique identifier for the category", example = "123", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Schema(description = "Name of the category", example = "AGD", required = true)
    private String name;

    @NotNull
    @Schema(description = "Indicates whether the category is enabled", example = "true", required = true)
    private Boolean enabled;

    @Schema(description = "Children of category")
    private Set<CategoryDto> children;
}