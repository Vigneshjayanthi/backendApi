package com.raghavstore.backend.service;

import com.raghavstore.backend.model.Product;
import com.raghavstore.backend.repo.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    public ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        List<Product> listOfProduct;
        listOfProduct = productRepository.findAll();
        if (listOfProduct.isEmpty()) {
            listOfProduct = null;
        }
        return listOfProduct;
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProduct(Long product_id)  throws RuntimeException{
        try {
            Optional<Product> product = productRepository.findById(product_id);
            return product;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public void deleteProduct(Long product_id) {
        try {
            productRepository.deleteById(product_id);
        } catch (Exception e) {
            throw new RuntimeException("no product id is present");
        }
    }

    @Override
    public Product updateProduct(Product updatingproduct) {
        try {
            Product product = this.getProduct(updatingproduct.getProductReferenceId()).get();
            Product updatedProduct = productRepository.save(this.updateCurrentProduct(product,updatingproduct));
            return updatedProduct;
        } catch (Exception e) {
            logger.error("error occurred during the product ==> "+ e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    private Product updateCurrentProduct(Product existingProduct, Product updatingProduct)  throws RuntimeException{
            if(!existingProduct.toString().equals(updatingProduct.toString())) {
                logger.info("new update is required for the specified product");
                existingProduct.setSku(updatingProduct.getSku());
                existingProduct.setMrp(updatingProduct.getMrp());
                existingProduct.setBrand(updatingProduct.getBrand());
                existingProduct.setColour(updatingProduct.getColour());
                existingProduct.setDescription(updatingProduct.getDescription());
                existingProduct.setTitle(updatingProduct.getTitle());
                existingProduct.setMaterial(updatingProduct.getMaterial());
                existingProduct.setImage_url1(updatingProduct.getImage_url1());
                existingProduct.setImage_url2(updatingProduct.getImage_url2());
                existingProduct.setImage_url3(updatingProduct.getImage_url3());
                existingProduct.setImage_url4(updatingProduct.getImage_url4());
                existingProduct.setImage_url5(updatingProduct.getImage_url5());
                return updatingProduct;
            }
            else{
                throw  new RuntimeException("Product data is upto date ==> no new details is available");
            }
    }
}
