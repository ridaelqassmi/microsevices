package com.elqassmi.services;

import com.elqassmi.dto.request.ProductRequest;
import com.elqassmi.dto.response.ProductResponse;
import jakarta.validation.Valid;

import java.util.List;


public interface ProductServices {
    long addproduct(@Valid ProductRequest product);

    void updateProduct(@Valid ProductRequest product, long productId);

    void deleteProduct(long id);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(long id);
}
