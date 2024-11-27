package com.simpleshop.product.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbstractAuditEntity {

    @NotNull
    @Schema(description = "The timestamp of the created time in ISO 8601 format", example = "2024-11-27T12:00:00"
            , format = "date-time", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime createdAt;

    @NotBlank
    @Size(max = 255)
    @Schema(description = "Name of the user that create this resource", example = "Smartphone", accessMode = Schema.AccessMode.READ_ONLY)
    private String createdBy;

    @NotNull
    @Schema(description = "The timestamp of the updated time in ISO 8601 format", example = "2024-11-27T12:00:00"
            , format = "date-time", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime updatedAt;

    @NotBlank
    @Size(max = 255)
    @Schema(description = "Name of the user that update this resource", example = "Smartphone", accessMode = Schema.AccessMode.READ_ONLY)
    private String updatedBy;

}
