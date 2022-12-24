package com.raghavstore.backend.model;

import jakarta.persistence.*;


@Entity
@Table(name="Product")
public class Product {
    @Id
    @Column(name = "product_reference_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productReferenceId;
    private String sku;
    private String title;
    private Double mrp;
    private String brand;
    private String material;
    private String image_url1;
    private String image_url2;
    private String image_url3;
    private String image_url4;
    private String image_url5;
    private String colour;
    private String description;

    public Product(Long productReferenceId, String sku, String title, Double mrp, String brand, String material, String image_url1, String image_url2, String image_url3, String image_url4, String image_url5, String colour, String description) {
        this.productReferenceId = productReferenceId;
        this.sku = sku;
        this.title = title;
        this.mrp = mrp;
        this.brand = brand;
        this.material = material;
        this.image_url1 = image_url1;
        this.image_url2 = image_url2;
        this.image_url3 = image_url3;
        this.image_url4 = image_url4;
        this.image_url5 = image_url5;
        this.colour = colour;
        this.description = description;
    }
    public Product(){

    }

    public Long getProductReferenceId() {
        return productReferenceId;
    }

    public void setProductReferenceId(Long productReferenceId) {
        this.productReferenceId = productReferenceId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getMrp() {
        return mrp;
    }

    public void setMrp(Double mrp) {
        this.mrp = mrp;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getImage_url1() {
        return image_url1;
    }

    public void setImage_url1(String image_url1) {
        this.image_url1 = image_url1;
    }

    public String getImage_url2() {
        return image_url2;
    }

    public void setImage_url2(String image_url2) {
        this.image_url2 = image_url2;
    }

    public String getImage_url3() {
        return image_url3;
    }

    public void setImage_url3(String image_url3) {
        this.image_url3 = image_url3;
    }

    public String getImage_url4() {
        return image_url4;
    }

    public void setImage_url4(String image_url4) {
        this.image_url4 = image_url4;
    }

    public String getImage_url5() {
        return image_url5;
    }

    public void setImage_url5(String image_url5) {
        this.image_url5 = image_url5;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
