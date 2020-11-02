package com.exalt.mongodemo;

import com.exalt.mongodemo.model.Product;
import com.exalt.mongodemo.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class MongoDemoApplicationTests {

    @Autowired
    ProductRepository repo;

    @Test
    void testSave() {
        Product product = new Product();
        product.setName("MAC Book Pro");
        product.setPrice(2000f);
        Product saveProduct = repo.save(product);
        Assertions.assertNotNull(saveProduct);
    }

    @Test
    void testFindAll() {
        List<Product> products = repo.findAll();
        Assertions.assertEquals(1, products.size());
    }

    @Test
    void testDelete() {
        repo.deleteById("5fa001cc4e05135611afd598");
        Optional<Product> product = repo.findById("5fa001cc4e05135611afd598");
        Assertions.assertTrue(!product.isPresent());
    }

}
