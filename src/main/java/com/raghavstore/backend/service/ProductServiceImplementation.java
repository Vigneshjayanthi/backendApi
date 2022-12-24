package com.raghavstore.backend.service;

import com.raghavstore.backend.model.Product;
import com.raghavstore.backend.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImplementation implements ProductService{

    @Autowired
    public ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        List<Product> listOfProduct;
        listOfProduct = productRepository.findAll();
        if(listOfProduct.isEmpty()){
            listOfProduct = null;
        }
        return listOfProduct;
    }

    @Override
    public Product insertProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProduct(Long product_id) {
        Optional<Product> product = productRepository.findById(product_id);
        return product;
    }


    @Override
    public void deleteProduct(Long product_id) {
        try {
            productRepository.deleteById(product_id);
        }
        catch (Exception e){
            throw new RuntimeException("no product id is present");
        }
    }

}
