package com.devlab.ecommerce.product.mapper;

import com.devlab.ecommerce.product.dto.ProductResponseDto;
import com.devlab.ecommerce.product.entity.Product;
import java.util.List;
import java.util.function.Function;

public final class ProductMapper {

//  private ProductMapper() {
//    List.of(new Product(),new Product()).stream().map(p -> {
//      return toResponseDto;
//    });
//  }
//
//  public ProductResponseDto toResponseDto(Product p) {
//    return ProductResponseDto.builder().productId(p.getId()).build();
//  }

//  public static Function<Product, ProductResponseDto> toResponseDto = product -> {
//    if (product == null) {
//      return null;
//    }
//
//    return ProductResponseDto.builder()
//        .productId(product.getId())
//        .name(product.getName())
//        .price(product.getPrice())
//        .description(
//            product.getProductDetails() != null
//                ? product.getProductDetails().getDescription()
//                : null
//        )
//        .imageURL(
//            product.getProductDetails() != null
//                ? product.getProductDetails().getImage()
//                : null
//        )
//        .build();
//  };
//
//
//  public static Function<List<Product>, List<ProductResponseDto>> toResponseDtoList = products -> {
//    return products.stream()
//        .map(toResponseDto)
//        .toList();
//  };

  public static List<ProductResponseDto> toResponseDtoList(List<Product> products) {
    return products.stream().map(ProductMapper::toResponseDto).toList();
  }

  public static ProductResponseDto toResponseDto(Product product) {
    return ProductResponseDto.builder()
        .productId(product.getId())
        .name(product.getName())
        .price(product.getPrice())
        .description(
            product.getProductDetails() != null
                ? product.getProductDetails().getDescription()
                : null
        )
        .imageURL(
            product.getProductDetails() != null
                ? product.getProductDetails().getImage()
                : null
        )
        .build();
  }
}
