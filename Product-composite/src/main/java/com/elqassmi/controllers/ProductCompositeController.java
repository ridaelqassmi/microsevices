package com.elqassmi.controllers;

import com.elqassmi.clients.ProductFeignClient;
import com.elqassmi.dto.request.ProductRequest;
import com.elqassmi.dto.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductCompositeController {
    @Autowired
    ProductFeignClient productFeignClient;


    @PostMapping

    public ResponseEntity<Void> addProduct(@RequestBody ProductRequest product){
        return  productFeignClient.addProduct(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@RequestBody ProductRequest product, @PathVariable("id") long productId){
         productFeignClient.updateProduct(product,productId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable long id) {
        productFeignClient.deleteProduct(id);
    }
    @GetMapping
    public List<ProductResponse> getAllProducts(){
        return productFeignClient.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable  long id){
        return productFeignClient.getProductById(id);
    }
}
