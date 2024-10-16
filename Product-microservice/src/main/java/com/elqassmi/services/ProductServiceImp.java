package com.elqassmi.services;

import com.elqassmi.dao.ProductRepository;
import com.elqassmi.domain.Produit;
import com.elqassmi.dto.request.ProductRequest;
import com.elqassmi.dto.response.ProductResponse;
import com.elqassmi.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductServices{
    @Autowired
    private ProductRepository productRepository;


    @Override
    public long addproduct(ProductRequest productRequest) {
        System.out.println(productRequest.getWeight());
        Produit produit = new Produit();
        produit.setName(productRequest.getName());
        produit.setWeight(productRequest.getWeight());
        productRepository.save(produit);
        return produit.getId();
    }

    @Override
    public void updateProduct(ProductRequest productRequest, long productId) {
        Optional<Produit> produit1 = productRepository.findById(productId);
        if (produit1.isPresent()) {
            produit1.get().setName(productRequest.getName());
            produit1.get().setWeight(productRequest.getWeight());
            productRepository.save(produit1.get());
        }
    }

    @Override
    public void deleteProduct(long id) {
        Optional<Produit> produit1 = productRepository.findById(id);
        produit1.ifPresent(produit -> productRepository.delete(produit));

    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Produit> products = productRepository.findAll();
        List<ProductResponse> listProduit = new ArrayList<ProductResponse>();
        for(Produit produit : products) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(produit.getId());
            productResponse.setName(produit.getName());
            productResponse.setWeight(produit.getWeight());
            listProduit.add(productResponse);
        }
        return listProduit;

    }

    @Override
    public ProductResponse getProductById(long id) {
        Optional<Produit> product = productRepository.findById(id);
        ProductResponse productResponse = new ProductResponse();
        if (product.isPresent()) {
            Produit produit1 = product.get();
            productResponse.setId(produit1.getId());
            productResponse.setName(produit1.getName());
            productResponse.setWeight(produit1.getWeight());

        }else {
            throw new ProductNotFoundException("Product with id = "+ id + " does not exist");
        }


        return productResponse;
    }
}
