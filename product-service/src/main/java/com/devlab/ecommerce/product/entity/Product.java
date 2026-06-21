package com.devlab.ecommerce.product.entity;

import com.devlab.ecommerce.product.enums.ProductStatus;
import com.devlab.ecommerce.product.enums.StockStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "products")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String id;

    private Long categoryId;

    private String sku;
    private String name;
    private String slug;

    private String brand;

    private BigDecimal price;
    private BigDecimal discountPrice;

    private StockStatus stockStatus;
    private ProductStatus status;

    private String thumbnail;
    private String shortDescription;

    private ProductDetails productDetails;
}