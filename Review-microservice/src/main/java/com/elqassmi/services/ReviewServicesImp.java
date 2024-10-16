package com.elqassmi.services;

import com.elqassmi.dao.ReviewRepository;
import com.elqassmi.domain.ProductReviewKey;
import com.elqassmi.domain.Review;
import com.elqassmi.dto.request.ReviewRequest;
import com.elqassmi.dto.response.ReviewResponse;
import com.elqassmi.exception.ReviewNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServicesImp implements ReviewServices {
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public ProductReviewKey addReview(ReviewRequest reviewRequest) {
        Review review = new Review();
        review.setAuthor(reviewRequest.getAuthor());
        review.setContent(reviewRequest.getContent());
        review.setSubject(reviewRequest.getSubject());
        review.setId(reviewRequest.getId());
        reviewRepository.save(review);
        return review.getId();
    }

    @Override
    public List<ReviewResponse> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        List<ReviewResponse> reviewResponses = new ArrayList<>();
        for(Review rev : reviews) {
            ReviewResponse reviewResponse = new ReviewResponse();
            reviewResponse.setAuthor(rev.getAuthor());
            reviewResponse.setSubject(rev.getSubject());
            reviewResponse.setId(rev.getId());
            reviewResponse.setId(rev.getId());
            reviewResponses.add(reviewResponse);
        }
        return reviewResponses;
    }

    @Override
    public ReviewResponse getReviewById(long reviewID, long productId) {
        ProductReviewKey productReviewKey = new ProductReviewKey(reviewID,productId);

        Optional<Review> review = reviewRepository.findById(productReviewKey);
        ReviewResponse reviewResponse = new ReviewResponse();
        if (review.isPresent()) {
            Review rev = review.get();
            reviewResponse.setAuthor(rev.getAuthor());
            reviewResponse.setSubject(rev.getSubject());
            reviewResponse.setId(rev.getId());
            reviewResponse.setContent(rev.getContent());



        }else {
            throw new ReviewNotFoundException("review with id = "+ productReviewKey+ " does not exist");
        }


        return reviewResponse;
    }

    @Override
    public void deleteReview(long reviewID, long productId) {
        ProductReviewKey productReviewKey = new ProductReviewKey(reviewID,productId);
        Optional<Review> review1 = reviewRepository.findById(productReviewKey);
        review1.ifPresent(review -> reviewRepository.delete(review));
    }

    @Override
    public void updateReview(long reviewID, long productId, ReviewRequest reviewRequest) {
        ProductReviewKey productReviewKey = new ProductReviewKey(reviewID,productId);

        Optional<Review> review1 = reviewRepository.findById(productReviewKey);
        if (review1.isPresent()) {
            Review review2 = review1.get();

            review2.setId(reviewRequest.getId());
            review2.setSubject(reviewRequest.getSubject());
            review2.setAuthor(reviewRequest.getAuthor());
            review2.setContent(reviewRequest.getContent());
            reviewRepository.save(review2);


        }

    }
}
