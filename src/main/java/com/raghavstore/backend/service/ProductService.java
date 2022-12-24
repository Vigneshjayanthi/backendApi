package com.raghavstore.backend.service;

import com.raghavstore.backend.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> getAllProduct();
    Product insertProduct(Product product);

    Optional<Product> getProduct(Long product_id);

    void deleteProduct(Long product_id);
}
