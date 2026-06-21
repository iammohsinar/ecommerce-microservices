package com.devlab.ecommerce.product.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {

  private String description;
  private String specifications;
  private String image;

  // SEO
  private String metaTitle;
  private String metaDescription;

  // Policies
  private Boolean returnable;
  private Integer returnWindowDays;
  private String warranty;

  // Store
  private long storeId;
}