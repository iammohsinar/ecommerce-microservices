package com.devlab.ecommerce.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_details")
public class ProductDetails {

  @Id
  private String id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", nullable = false, unique = true)
  private Product product;

  private String description;

  private String specifications;

  @Column(name = "image_url")
  private String image;

  /*
   * SEO
   */
  private String metaTitle;
  private String metaDescription;

  /*
   * Policies
   */
  private Boolean returnable;
  private Integer returnWindowDays;
  private String warranty;

  /*
  * Store
  */
  private Long storeId;
}
