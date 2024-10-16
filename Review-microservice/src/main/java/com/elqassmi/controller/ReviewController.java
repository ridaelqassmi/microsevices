package com.elqassmi.controller;

import com.elqassmi.domain.ProductReviewKey;
import com.elqassmi.dto.request.ReviewRequest;
import com.elqassmi.dto.response.ReviewResponse;
import com.elqassmi.services.ReviewServices;
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
@RequestMapping("api/reviews")
public class ReviewController {
    @Autowired
    ReviewServices reviewServices;
    Logger logger = LoggerFactory.getLogger(ReviewController.class);

    @PostMapping
    public ResponseEntity<Void> addRecommendation(@RequestBody ReviewRequest reviewRequest) {
        logger.info("*****************Location {}", reviewRequest.toString());
        ProductReviewKey id = reviewServices.addReview(reviewRequest);
        //logger.info("*************Location : after persistence");
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri ).build();

    }

    @PutMapping("/{ReviewID}/{ProductId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLocation(@Valid @RequestBody ReviewRequest reviewRequest,
                               @PathVariable("ReviewID") long reviewID,
                               @PathVariable("ProductId") long productId ) {
        reviewServices.updateReview(reviewID, productId,reviewRequest);

    }

    @DeleteMapping("/{ReviewID}/{ProductId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecommendation(@PathVariable("ReviewID") long reviewID,@PathVariable("ProductId") long ProductId) {
        reviewServices.deleteReview(reviewID,ProductId);
    }

    @GetMapping
    public List<ReviewResponse> getAllRecommandations() {
        List<ReviewResponse> allReviews = new ArrayList<>();
        allReviews= reviewServices.getAllReviews();
        return allReviews;

    }

    @GetMapping("/{ReviewID}/{ProductId}")
    public ResponseEntity<ReviewResponse> getRecommandationById(@PathVariable("ReviewID") long reviewID,
                                                                        @PathVariable("ProductId") long productId) {

        ReviewResponse review = reviewServices.getReviewById(reviewID,productId);
        return ResponseEntity.ok().body(review);
    }

}
