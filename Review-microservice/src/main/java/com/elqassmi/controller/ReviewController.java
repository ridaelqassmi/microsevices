package com.elqassmi.controller;

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
    public ResponseEntity<Void> addReview(@Valid @RequestBody ReviewRequest reviewRequest) {
        logger.info("*****************Review {}", reviewRequest.toString());
        long id = reviewServices.addReview(reviewRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri ).build();

    }

    @PutMapping("/{ReviewID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateReview(@Valid @RequestBody ReviewRequest reviewRequest,
                               @PathVariable("ReviewID") long reviewID) {
        reviewServices.updateReview(reviewID,reviewRequest);

    }

    @DeleteMapping("/{ReviewID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable("ReviewID") long reviewID) {
        reviewServices.deleteReview(reviewID);
    }

    @GetMapping
    public List<ReviewResponse> getAllReviews() {
        List<ReviewResponse> allReviews = new ArrayList<>();
        allReviews= reviewServices.getAllReviews();
        return allReviews;

    }

    @GetMapping("/{ReviewID}")
    public ResponseEntity<ReviewResponse> getReviewById(@PathVariable("ReviewID") long reviewID) {

        ReviewResponse review = reviewServices.getReviewById(reviewID);
        return ResponseEntity.ok().body(review);
    }

}
