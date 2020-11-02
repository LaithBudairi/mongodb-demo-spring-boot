package com.exalt.mongodemo.repository;

import com.exalt.mongodemo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
