package com.elqassmi.services;

import com.elqassmi.domain.ProductReviewKey;
import com.elqassmi.dto.request.ReviewRequest;
import com.elqassmi.dto.response.ReviewResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewServices {
    ProductReviewKey addReview(ReviewRequest reviewRequest);

    List<ReviewResponse> getAllReviews();

    ReviewResponse getReviewById(long reviewID, long productId);

    void deleteReview(long reviewID, long productId);

    void updateReview(long reviewID, long productId, @Valid ReviewRequest reviewRequest);
}
