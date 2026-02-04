package com.devlab.ecommerce.product.entity;

import com.devlab.ecommerce.product.enums.ProductStatus;
import com.devlab.ecommerce.product.enums.StockStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private String id;

    private Long categoryId;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;

    private String brand;

    private BigDecimal price;

    private BigDecimal discountPrice;

    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    private String thumbnail;

    private String shortDescription;

  @OneToOne(mappedBy = "product", fetch = FetchType.LAZY)
  private ProductDetails productDetails;



}
