package com.simpleshop.product.controller;

import com.simpleshop.product.payload.ErrorResponse;
import com.simpleshop.product.payload.ProductDto;
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
@Tag(name = "Products", description = "Operations for managing and retrieving product information")
public class ProductController {

    // --------- Admin Endpoints ---------

    @Operation(
            summary = "Create a New Product (Admin)",
            description = "Allows administrators to create a new product by providing all necessary details, such as name, description, price, stock status, and more.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Product successfully created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid product data provided", content = {
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
    @PostMapping("/admin/products")
    public ResponseEntity<ProductDto> createProduct(
            @Valid @RequestBody(required = false) ProductDto productDto
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Retrieve All Products (Admin)",
            description = "Allows administrators to retrieve a paginated list of all products, sorted and filtered as needed.",
            parameters = {
                    @Parameter(name = "page", description = "Page number for pagination (1-based)", example = "1"),
                    @Parameter(name = "sortField", description = "Field to sort the results by", example = "name"),
                    @Parameter(name = "sortDir", description = "Sort direction: ASC or DESC", example = "ASC")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Paginated list of products", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid query parameters", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @GetMapping("/admin/products")
    public ResponseEntity<List<ProductDto>> listProductsByPage(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "sortField", defaultValue = "name") String sortField,
            @RequestParam(value = "sortDir", defaultValue = "ASC") String sortDir) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Get Product Details by ID (Admin)",
            description = "Allows administrators to retrieve detailed information about a product by its unique identifier.",
            parameters = {
                    @Parameter(name = "id", description = "Unique product identifier", example = "123")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Product details retrieved", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid product ID", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Product not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @GetMapping("/admin/products/{id}")
    public ResponseEntity<ProductDto> getProductById(
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Update Product (Admin)",
            description = "Allows administrators to update the details of an existing product using its unique ID.",
            parameters = {
                    @Parameter(name = "id", description = "Unique product identifier", example = "123")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Product updated successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid product data", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Product not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @PutMapping("/admin/products/{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable("id") Long id,
            @Valid @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Delete Product (Admin)",
            description = "Allows administrators to delete a product by its unique ID.",
            parameters = {
                    @Parameter(name = "id", description = "Unique product identifier", example = "123")
            },
            responses = {
                    @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid product ID", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Product not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @DeleteMapping("/admin/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    // --------- Client Endpoints ---------

    @Operation(
            summary = "List Products (Client)",
            description = "Allows clients to view a paginated list of available products, filtered by criteria such as price or keywords.",
            parameters = {
                    @Parameter(name = "page", description = "Page number for pagination (1-based)", example = "1"),
                    @Parameter(name = "sortField", description = "Field to sort the results by", example = "name"),
                    @Parameter(name = "sortDir", description = "Sort direction: ASC or DESC", example = "ASC"),
                    @Parameter(name = "priceFrom", description = "Minimum product price", example = "10.00"),
                    @Parameter(name = "priceTo", description = "Maximum product price", example = "500.00"),
                    @Parameter(name = "searchKeyword", description = "Keyword to search products by name or description", example = "Smartphone")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Paginated list of products", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid query parameters", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @GetMapping("/client/products")
    public ResponseEntity<List<ProductDto>> clientListProductsByPage(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "sortField", defaultValue = "name") String sortField,
            @RequestParam(value = "sortDir", defaultValue = "ASC") String sortDir,
            @RequestParam(value = "priceFrom", required = false) Double priceFrom,
            @RequestParam(value = "priceTo", required = false) Double priceTo,
            @RequestParam(value = "searchKeyword", required = false) String searchKeyword) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Get Product Details by ID (Client)",
            description = "Allows clients to retrieve details of a product using its unique identifier.",
            parameters = {
                    @Parameter(name = "id", description = "Unique product identifier", example = "123")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Product details retrieved", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid product ID", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Product not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @GetMapping("/client/products/{id}")
    public ResponseEntity<ProductDto> clientGetProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
