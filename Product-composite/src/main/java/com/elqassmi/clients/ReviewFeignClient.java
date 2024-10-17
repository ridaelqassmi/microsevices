package com.elqassmi.clients;

import com.elqassmi.dto.request.ReviewRequest;
import com.elqassmi.dto.response.ReviewResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "REVIEW-MICROSERVICES", url = "http://localhost:7002/")
public interface ReviewFeignClient {
    @PostMapping("api/reviews")
    public ResponseEntity<Void> addReview(@RequestBody ReviewRequest reviewRequest);

    @PutMapping("api/reviews/{ReviewID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateReview( @RequestBody ReviewRequest reviewRequest,
                             @PathVariable("ReviewID") long reviewID) ;

    @DeleteMapping("api/reviews/{ReviewID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable("ReviewID") long reviewID) ;

    @GetMapping("api/reviews")
    public List<ReviewResponse> getAllReviews() ;

    @GetMapping("/{ReviewID}")
    public ResponseEntity<ReviewResponse> getReviewById(@PathVariable("ReviewID") long reviewID);

    @GetMapping("api/products/{id}/reviews")
    public List<ReviewResponse> getAllReviewByProductId(@PathVariable long id);

}
