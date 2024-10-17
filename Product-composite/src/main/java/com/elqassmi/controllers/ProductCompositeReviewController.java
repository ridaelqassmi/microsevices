package com.elqassmi.controllers;

import com.elqassmi.clients.ReviewFeignClient;
import com.elqassmi.dto.request.ReviewRequest;
import com.elqassmi.dto.response.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/composite/reviews")
public class ProductCompositeReviewController {

    @Autowired
    private ReviewFeignClient reviewFeignClient;

    @PostMapping

    public ResponseEntity<Void> addReview(@RequestBody ReviewRequest reviewRequest){
        return reviewFeignClient.addReview(reviewRequest);
    }

    @PutMapping("/{ReviewID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateReview( @RequestBody ReviewRequest reviewRequest,
                              @PathVariable("ReviewID") long reviewID){
         reviewFeignClient.updateReview(reviewRequest,reviewID);
    }

    @DeleteMapping("/{ReviewID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable("ReviewID") long reviewID){
        reviewFeignClient.deleteReview(reviewID);
    }

    @GetMapping
    public List<ReviewResponse> getAllReviews(){
        return reviewFeignClient.getAllReviews();
    }

    @GetMapping("/{ReviewID}")
    public ResponseEntity<ReviewResponse> getReviewById(@PathVariable("ReviewID") long reviewID){
        return reviewFeignClient.getReviewById(reviewID);
    }

}
