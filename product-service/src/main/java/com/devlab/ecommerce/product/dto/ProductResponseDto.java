package com.devlab.ecommerce.product.dto;


import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class ProductResponseDto {

  private String productId;
  private BigDecimal price;
  private String name;
  private String description;
  private String imageURL;

}
