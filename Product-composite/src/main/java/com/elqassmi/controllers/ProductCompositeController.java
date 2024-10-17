package com.elqassmi.controllers;


import com.elqassmi.dto.request.ProductRequest;
import com.elqassmi.dto.response.ProductFullResponse;
import com.elqassmi.dto.response.ProductResponse;

import com.elqassmi.services.ProduitCompositeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/composite/products")
public class ProductCompositeController {

    @Autowired
    private ProduitCompositeServices produiCompositeServices;


    //here we are going to implement the most important method
    @GetMapping("/{id}")
    public ProductFullResponse getProducts(@PathVariable int id) {
        return produiCompositeServices.getProductDetailsById(id);
    }


    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody ProductRequest product){
        return  produiCompositeServices.addProduct(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@RequestBody ProductRequest product, @PathVariable("id") long productId){
         produiCompositeServices.updateProduct(product,productId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable long id) {
        produiCompositeServices.deleteProduct(id);
    }
    @GetMapping
    public List<ProductResponse> getAllProducts(){
        return produiCompositeServices.getAllProducts();
    }

}
