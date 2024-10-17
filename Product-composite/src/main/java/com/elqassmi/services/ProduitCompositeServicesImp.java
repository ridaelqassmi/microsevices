package com.elqassmi.services;

import com.elqassmi.clients.ProductFeignClient;
import com.elqassmi.clients.RecommendationFeignClient;
import com.elqassmi.clients.ReviewFeignClient;
import com.elqassmi.dto.request.ProductRequest;
import com.elqassmi.dto.response.ProductFullResponse;
import com.elqassmi.dto.response.ProductResponse;
import com.elqassmi.dto.response.RecommandationResponse;
import com.elqassmi.dto.response.ReviewResponse;
import com.elqassmi.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class ProduitCompositeServicesImp implements ProduitCompositeServices{

    @Autowired
    private ProductFeignClient productFeignClient;
    @Autowired
    private RecommendationFeignClient recommendationFeignClient;
    @Autowired
    private ReviewFeignClient reviewFeignClient;

    public ProductFullResponse getProductDetailsById(long id) {
        ProductFullResponse product = new ProductFullResponse();

        // Get product by ID
        ProductResponse productResponse = productFeignClient.getProductById(id).getBody();
        if (productResponse == null) {
            //throw new ProductNotFoundException("Product with ID " + id + " not found.");
        }

        // Get reviews for the product
        List<ReviewResponse> reviewResponse = reviewFeignClient.getAllReviewByProductId(productResponse.getId());
        if (reviewResponse == null || reviewResponse.isEmpty()) {
            //throw new ProductNotFoundException("No reviews found for product with ID " + productResponse.getId());
        }

        // Get recommendations for the product
        List<RecommandationResponse> recommandationResponses = recommendationFeignClient.getRecommendation(productResponse.getId());
        if (recommandationResponses == null || recommandationResponses.isEmpty()) {
            throw new ProductNotFoundException("No recommendations found for product with ID " + productResponse.getId());
        }

        // Set the product details
        product.setId(productResponse.getId());
        product.setName(productResponse.getName());
        product.setWeight(productResponse.getWeight());
        product.setReviews(reviewResponse);
        product.setRecommandations(recommandationResponses);

        return product;
    }




    @Override
    public ResponseEntity<Void> addProduct(ProductRequest product) {
        return productFeignClient.addProduct(product);
    }

    @Override
    public void updateProduct(ProductRequest product, long productId) {
        productFeignClient.updateProduct(product, productId);
    }

    @Override
    public void deleteProduct(long id) {
        productFeignClient.deleteProduct(id);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productFeignClient.getAllProducts();
    }

}