package com.devlab.ecommerce.product.repository.springdata;

import com.devlab.ecommerce.product.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringMongoProductRepository extends MongoRepository<Product, String> {

}
