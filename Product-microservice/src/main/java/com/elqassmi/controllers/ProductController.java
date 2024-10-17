package com.elqassmi.controllers;

import com.elqassmi.dto.request.ProductRequest;
import com.elqassmi.dto.response.ProductResponse;
import com.elqassmi.services.ProductServices;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServices productService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @PostMapping
    public ResponseEntity<Void> addProduct(@Valid @RequestBody ProductRequest product) {
        logger.info("*****************product {}", product.toString());
        long id = productService.addproduct(product);
        //logger.info("*************Location : after persistence");
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri ).build();

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@Valid @RequestBody ProductRequest product,
                              @PathVariable("id") long productId) {
        productService.updateProduct(product, productId);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts(){
        List<ProductResponse> allProducts = new ArrayList<>();
        allProducts = productService.getAllProducts();
        return allProducts;

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable  long id) {

        ProductResponse product = productService.getProductById(id);
        logger.info("****** appel de produit avec id : " + id);
        return ResponseEntity.ok().body(product);
    }

}
