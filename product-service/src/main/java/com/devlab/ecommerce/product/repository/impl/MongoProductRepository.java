package com.devlab.ecommerce.product.repository.impl;

import com.devlab.ecommerce.product.entity.Product;
import com.devlab.ecommerce.product.repository.ProductRepository;
import com.devlab.ecommerce.product.repository.springdata.SpringMongoProductRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
@ConditionalOnProperty(name = "product.db.enabled", havingValue = "true", matchIfMissing = true)
public class MongoProductRepository implements ProductRepository {

  private final SpringMongoProductRepository repository;

  @Override
  public List<Product> findAll() {
    return repository.findAll();
  }

  @Override
  public Optional<Product> findById(String id) {
    return Optional.empty();
  }
}
