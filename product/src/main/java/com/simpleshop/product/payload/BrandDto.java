package com.simpleshop.product.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "BrandDto", description = "Brand request/response data structure used for API operations")
public class BrandDto {

    @Schema(description = "Unique identifier for the brand", example = "123", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Schema(description = "Name of the brand", example = "Smartphone", required = true)
    private String name;

}