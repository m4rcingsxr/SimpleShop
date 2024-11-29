package com.simpleshop.products.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank
    @Size(max = 255)
    @Column(name = "short_description", nullable = false)
    private String shortDescription;

    @NotBlank
    @Size(max = 2550)
    @Column(name = "full_description", nullable = false, length = 2550)
    private String fullDescription;

    @NotNull
    @Column(name = "in_stock", nullable = false)
    private Boolean inStock;

    @NotNull
    @DecimalMin("0.01")
    @DecimalMax("50.0")
    @Column(name = "weight", nullable = false)
    private BigDecimal weight;

    @NotNull
    @DecimalMin("0.01")
    @DecimalMax("300.0")
    @Column(name = "width", nullable = false)
    private BigDecimal width;

    @NotNull
    @DecimalMin("0.01")
    @DecimalMax("200.0")
    @Column(name = "height", nullable = false)
    private BigDecimal height;

    @NotNull
    @DecimalMin("0.01")
    @DecimalMax("300.0")
    @Column(name = "length", nullable = false)
    private BigDecimal length;

    @NotNull
    @DecimalMin("0.01")
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @NotNull
    @DecimalMin("0.01")
    @Column(name = "cost", nullable = false)
    private BigDecimal cost;

    @DecimalMin("0.00")
    @DecimalMax("100.0")
    @Column(name = "discount_percent", nullable = false)
    private BigDecimal discountPercent;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
}
