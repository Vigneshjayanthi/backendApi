package com.raghavstore.backend.controller;

import com.raghavstore.backend.model.Product;
import com.raghavstore.backend.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    public ProductService productService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @GetMapping("/all")
    public ResponseEntity getAll(){
        List<Product> listOfProducts = productService.getAllProduct();
        ResponseEntity re = new ResponseEntity(listOfProducts, HttpStatus.OK);
        return re;
    }

    @PostMapping("/create/product")
    public ResponseEntity createProduct(@RequestBody Product product){
        ResponseEntity re;
        Product insertProduct = productService.insertProduct(product);
        if(insertProduct!= null){
            re = new ResponseEntity<>(insertProduct,HttpStatus.CREATED);
        }
        else{
            String message = "Product is not created";
            re = new ResponseEntity(message,HttpStatus.BAD_REQUEST);
        }
        return  re;
    }

    @GetMapping("/product/")
    public ResponseEntity getSpecificProduct(@RequestParam Long product_id){
        logger.info("the specific product method is called ",product_id);
        ResponseEntity re;
        if(product_id>0){
            if(productService.getProduct(product_id).isPresent()) {
                Product getProductId = productService.getProduct(product_id).get();
                re = new ResponseEntity(getProductId, HttpStatus.OK);
            }
            else{
                re = new ResponseEntity<>("No product is found", HttpStatus.NOT_FOUND);
            }
        }
        else{
            re = new ResponseEntity("Please enter the proper product Id",HttpStatus.BAD_REQUEST);
        }
        return re;
    }

    @DeleteMapping("product/deleteProduct/")
    public ResponseEntity removeProduct(@RequestParam("product_id") Long productId){
        logger.info("The Delete Product Method is called");
       try{
           productService.deleteProduct(productId);
           return new ResponseEntity("Product is deleted Successfully "+productId,HttpStatus.ACCEPTED);
       }
       catch (Exception e){
           logger.error(e.getMessage());
           return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
       }
    }
}
