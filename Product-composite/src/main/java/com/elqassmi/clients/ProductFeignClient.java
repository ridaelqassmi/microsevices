package com.elqassmi.clients;

import com.elqassmi.dto.request.ProductRequest;
import com.elqassmi.dto.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name = "product-microservice",url = "http://localhost:7001/api/products")
@FeignClient(name = "PRODUCT-MICROSERVICE",url="http://localhost:7001/")

public interface ProductFeignClient {
    @PostMapping("api/products")

     ResponseEntity<Void> addProduct(@RequestBody ProductRequest product);

    @PutMapping("api/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
     void updateProduct(@RequestBody ProductRequest product, @PathVariable("id") long productId);

    @DeleteMapping("api/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProduct(@PathVariable long id) ;
    @GetMapping("api/products")
    List<ProductResponse> getAllProducts();

    @GetMapping("api/products/{id}")
    ResponseEntity<ProductResponse> getProductById(@PathVariable  long id);


}
