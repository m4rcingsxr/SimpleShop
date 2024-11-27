package com.simpleshop.product.controller;

import com.simpleshop.product.payload.CategoryRequestDto;
import com.simpleshop.product.payload.CategoryResponseDto;
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
@Tag(name = "Categories", description = "Operations for managing and retrieving category information")
public class CategoryController {

    // --------- Admin Endpoints ---------

    @Operation(
            summary = "Create a New Category (Admin)",
            description = "Allows administrators to create a new category by providing its name, parent category, and other details.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Category successfully created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryResponseDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid category data provided", content = {
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
    @PostMapping("/admin/categories")
    public ResponseEntity<CategoryResponseDto> createCategory(
            @Valid @RequestBody CategoryRequestDto categoryRequestDto
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Retrieve All Categories (Admin)",
            description = "Allows administrators to retrieve a paginated list of all categories.",
            parameters = {
                    @Parameter(name = "page", description = "Page number for pagination (1-based)", example = "1"),
                    @Parameter(name = "sortField", description = "Field to sort the results by", example = "name"),
                    @Parameter(name = "sortDir", description = "Sort direction: ASC or DESC", example = "ASC")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Paginated list of categories", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryResponseDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid query parameters", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @GetMapping("/admin/categories")
    public ResponseEntity<List<CategoryResponseDto>> listCategoriesByPage(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "sortField", defaultValue = "name") String sortField,
            @RequestParam(value = "sortDir", defaultValue = "ASC") String sortDir) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Get Category Details by ID (Admin)",
            description = "Allows administrators to retrieve detailed information about a category by its unique identifier.",
            parameters = {
                    @Parameter(name = "id", description = "Unique category identifier", example = "123")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Category details retrieved", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryResponseDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid category ID", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Category not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @GetMapping("/admin/categories/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Update Category (Admin)",
            description = "Allows administrators to update the details of an existing category using its unique ID.",
            parameters = {
                    @Parameter(name = "id", description = "Unique category identifier", example = "123")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Category updated successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryResponseDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid category data", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Category not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @PutMapping("/admin/categories/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(
            @PathVariable("id") Long id,
            @Valid @RequestBody CategoryRequestDto categoryRequestDto) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Delete Category (Admin)",
            description = "Allows administrators to delete a category by its unique ID.",
            parameters = {
                    @Parameter(name = "id", description = "Unique category identifier", example = "123")
            },
            responses = {
                    @ApiResponse(responseCode = "204", description = "Category deleted successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid category ID", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Category not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @DeleteMapping("/admin/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
