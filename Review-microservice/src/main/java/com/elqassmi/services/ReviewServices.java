package com.elqassmi.services;

import com.elqassmi.domain.ProductReviewKey;
import com.elqassmi.dto.request.ReviewRequest;
import com.elqassmi.dto.response.ReviewResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewServices {
     List<ReviewResponse> getAllReviewByProductId(long id) ;

    long addReview(ReviewRequest reviewRequest);

    List<ReviewResponse> getAllReviews();

    ReviewResponse getReviewById(long reviewID);

    void deleteReview(long reviewID);

    void updateReview(long reviewID, @Valid ReviewRequest reviewRequest);
}
