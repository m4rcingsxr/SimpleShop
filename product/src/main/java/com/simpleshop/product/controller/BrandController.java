package com.simpleshop.product.controller;

import com.simpleshop.product.payload.BrandDto;
import com.simpleshop.product.payload.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Brands", description = "Operations for managing and retrieving brand information")
public class BrandController {

    // --------- Admin Endpoints ---------

    @Operation(
            summary = "Create a New Brand (Admin)",
            description = "Allows administrators to create a new brand by providing its name.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Brand successfully created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = BrandDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid brand data provided", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "403", description = "Access denied", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @PostMapping("/admin/brands")
    public ResponseEntity<BrandDto> createBrand(
            @Valid @RequestBody BrandDto brandDto
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Retrieve All Brands (Admin)",
            description = "Allows administrators to retrieve a paginated list of all brands.",
            parameters = {
                    @Parameter(name = "page", description = "Page number for pagination (1-based)", example = "1"),
                    @Parameter(name = "sortField", description = "Field to sort the results by", example = "name"),
                    @Parameter(name = "sortDir", description = "Sort direction: ASC or DESC", example = "ASC")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Paginated list of brands", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = BrandDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid query parameters", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @GetMapping("/admin/brands")
    public ResponseEntity<List<BrandDto>> listBrandsByPage(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "sortField", defaultValue = "name") String sortField,
            @RequestParam(value = "sortDir", defaultValue = "ASC") String sortDir) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Get Brand Details by ID (Admin)",
            description = "Allows administrators to retrieve detailed information about a brand by its unique identifier.",
            parameters = {
                    @Parameter(name = "id", description = "Unique brand identifier", example = "123")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Brand details retrieved", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = BrandDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid brand ID", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Brand not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @GetMapping("/admin/brands/{id}")
    public ResponseEntity<BrandDto> getBrandById(
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Update Brand (Admin)",
            description = "Allows administrators to update the details of an existing brand using its unique ID.",
            parameters = {
                    @Parameter(name = "id", description = "Unique brand identifier", example = "123")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Brand updated successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = BrandDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid brand data", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Brand not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @PutMapping("/admin/brands/{id}")
    public ResponseEntity<BrandDto> updateBrand(
            @PathVariable("id") Long id,
            @Valid @RequestBody BrandDto brandDto) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Delete Brand (Admin)",
            description = "Allows administrators to delete a brand by its unique ID.",
            parameters = {
                    @Parameter(name = "id", description = "Unique brand identifier", example = "123")
            },
            responses = {
                    @ApiResponse(responseCode = "204", description = "Brand deleted successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid brand ID", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Brand not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @DeleteMapping("/admin/brands/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
