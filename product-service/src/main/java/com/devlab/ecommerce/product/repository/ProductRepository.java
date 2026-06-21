package com.devlab.ecommerce.product.repository;

import com.devlab.ecommerce.product.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

  List<Product> findAllProductsByStoreId(long storeId);

  Optional<Product> findById(String id);
}