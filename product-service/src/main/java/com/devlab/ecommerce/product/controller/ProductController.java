package com.devlab.ecommerce.product.controller;

import com.devlab.ecommerce.product.dto.ProductResponseDto;
import com.devlab.ecommerce.product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/v1/store/{storeId}/getAllProducts")
  public List<ProductResponseDto> getAllProducts( @PathVariable long storeId) {
    return productService.getAllProducts(storeId);
  }
}
