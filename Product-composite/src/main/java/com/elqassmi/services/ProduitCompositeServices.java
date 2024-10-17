package com.elqassmi.services;

import com.elqassmi.dto.request.ProductRequest;
import com.elqassmi.dto.response.ProductFullResponse;
import com.elqassmi.dto.response.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface ProduitCompositeServices {
    public ProductFullResponse getProductDetailsById(@PathVariable long id);

    ResponseEntity<Void> addProduct(ProductRequest product);

    void updateProduct(ProductRequest product, long productId);

    void deleteProduct(long id);

    List<ProductResponse> getAllProducts();
}
