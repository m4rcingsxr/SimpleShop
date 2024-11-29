package com.simpleshop.products.controller;

import com.simpleshop.products.payload.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Products", description = "Operations for managing and retrieving products information")
public class ProductController {

    private final Environment environment;
    private final ProductsContactInfoDto productsContactInfo;

    // --------- Admin Endpoints ---------

    @Operation(
            summary = "Create a New Product (Admin)",
            description = "Allows administrators to create a new products by providing all necessary details, such as name, description, price, stock status, and more."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Product successfully created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid products data provided", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))
            }),
            @ApiResponse(responseCode = "403", description = "Access denied", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    @PostMapping("/admin/products")
    public ResponseEntity<ProductResponseDto> createProduct(
            @Valid @RequestBody(required = false) ProductRequestDto productRequestDto
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
            }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Paginated list of products", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid query parameters", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    @GetMapping("/admin/products")
    public ResponseEntity<List<ProductResponseDto>> listProductsByPage(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "sortField", defaultValue = "name") String sortField,
            @RequestParam(value = "sortDir", defaultValue = "ASC") String sortDir) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Get Product Details by ID (Admin)",
            description = "Allows administrators to retrieve detailed information about a products by its unique identifier.",
            parameters = {
                    @Parameter(name = "id", description = "Unique products identifier", example = "123")
            }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product details retrieved", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid products ID", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Product not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    @GetMapping("/admin/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Update Product (Admin)",
            description = "Allows administrators to update the details of an existing products using its unique ID.",
            parameters = {
                    @Parameter(name = "id", description = "Unique products identifier", example = "123")
            }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product updated successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid products data", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Product not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    @PutMapping("/admin/products/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(
            @PathVariable("id") Long id,
            @Valid @RequestBody ProductRequestDto productDto) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Delete Product (Admin)",
            description = "Allows administrators to delete a products by its unique ID.",
            parameters = {
                    @Parameter(name = "id", description = "Unique products identifier", example = "123")
            }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid products ID", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Product not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
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
                    @Parameter(name = "priceFrom", description = "Minimum products price", example = "10.00"),
                    @Parameter(name = "priceTo", description = "Maximum products price", example = "500.00"),
                    @Parameter(name = "searchKeyword", description = "Keyword to search products by name or description", example = "Smartphone")
            }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Paginated list of products", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid query parameters", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    @GetMapping("/client/products")
    public ResponseEntity<List<ProductResponseDto>> clientListProductsByPage(
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
            description = "Allows clients to retrieve details of a products using its unique identifier.",
            parameters = {
                    @Parameter(name = "id", description = "Unique products identifier", example = "123")
            }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product details retrieved", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid products ID", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Product not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    @GetMapping("/client/products/{id}")
    public ResponseEntity<ProductResponseDto> clientGetProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Get Java version",
            description = "Get Java versions details that is installed into products microservice"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    }
    )
    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("JAVA_HOME"));
    }

    @Operation(
            summary = "Get Contact Info",
            description = "Contact Info details that can be reached out in case of any issues"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    }
    )
    @GetMapping("/contact-info")
    public ResponseEntity<ProductsContactInfoDto> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productsContactInfo);
    }

}
