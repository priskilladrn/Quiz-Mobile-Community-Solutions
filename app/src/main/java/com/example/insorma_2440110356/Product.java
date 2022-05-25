package com.example.insorma_2440110356;

import android.media.Image;

public class Product {
    String productName, productPrice;
    Double productRating;
    Integer productId, productImage;

    public Product(Integer _productId, Integer _productImage, String _productName, String _productPrice, Double _productRating){
        productId = _productId;
        productImage = _productImage;
        productName = _productName;
        productPrice = _productPrice;
        productRating = _productRating;
    }

    public Integer getProductImage() {
        return productImage;
    }

    public String getProductName() {
        return productName;
    }

    public Double getProductRating() {
        return productRating;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductPrice() {
        return productPrice;
    }
}