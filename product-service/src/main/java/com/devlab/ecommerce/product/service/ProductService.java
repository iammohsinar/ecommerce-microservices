package com.devlab.ecommerce.product.service;

import com.devlab.ecommerce.product.dto.ProductResponseDto;
import com.devlab.ecommerce.product.entity.Product;
import com.devlab.ecommerce.product.mapper.ProductMapper;
import com.devlab.ecommerce.product.repository.ProductRepository;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<ProductResponseDto> getAllProducts(long storeId) throws NoSuchElementException {
    List<Product> products = productRepository.findAllProductsByStoreId(storeId);
    if(products.isEmpty())
      throw new NoSuchElementException("No product is available");
    return ProductMapper.toResponseDtoList(products);
  }

}
