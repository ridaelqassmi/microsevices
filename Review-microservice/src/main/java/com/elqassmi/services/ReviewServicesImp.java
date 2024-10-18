package com.elqassmi.services;

import com.elqassmi.dao.ReviewRepository;
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
    public List<ReviewResponse> getAllReviewByProductId(long id) {
        List<Review> reviews = reviewRepository.findAllByProductId(id);
        List<ReviewResponse> reviewResponses = new ArrayList<>();
        for (Review review : reviews) {
            ReviewResponse reviewResponse = new ReviewResponse();
            reviewResponse.setReviewId(review.getReviewId());
            reviewResponse.setProductId(review.getProductId());
            reviewResponse.setSubject(review.getSubject());
            reviewResponse.setAuthor(review.getAuthor());
            reviewResponse.setContent(review.getContent());
            reviewResponses.add(reviewResponse);
        }
        return reviewResponses;
    }

    @Override
    public long addReview(ReviewRequest reviewRequest) {
        Review review = new Review();
        review.setAuthor(reviewRequest.getAuthor());
        review.setContent(reviewRequest.getContent());
        review.setSubject(reviewRequest.getSubject());
        review.setContent(reviewRequest.getContent());
        review.setProductId(reviewRequest.getProductId());

        reviewRepository.save(review);
        return review.getReviewId();
    }

    @Override
    public List<ReviewResponse> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        List<ReviewResponse> reviewResponses = new ArrayList<>();
        for(Review rev : reviews) {
            ReviewResponse reviewResponse = new ReviewResponse();
            reviewResponse.setAuthor(rev.getAuthor());
            reviewResponse.setSubject(rev.getSubject());
            reviewResponse.setProductId(rev.getProductId());
            reviewResponse.setReviewId(rev.getReviewId());
            reviewResponse.setContent(rev.getContent());

            reviewResponses.add(reviewResponse);
        }
        return reviewResponses;
    }

    @Override
    public ReviewResponse getReviewById(long reviewID) {

        Optional<Review> review = reviewRepository.findById(reviewID);
        ReviewResponse reviewResponse = new ReviewResponse();
        if (review.isPresent()) {
            Review rev = review.get();
            reviewResponse.setAuthor(rev.getAuthor());
            reviewResponse.setSubject(rev.getSubject());
            reviewResponse.setProductId(rev.getProductId());
            reviewResponse.setReviewId(rev.getReviewId());
            reviewResponse.setContent(rev.getContent());



        }else {
            throw new ReviewNotFoundException("review with id = "+ reviewID+ " does not exist");
        }


        return reviewResponse;
    }

    @Override
    public void deleteReview(long reviewID) {
        Optional<Review> review1 = reviewRepository.findById(reviewID);
        review1.ifPresent(review -> reviewRepository.delete(review));
    }

    @Override
    public void updateReview(long reviewID, ReviewRequest reviewRequest) {

        Optional<Review> review1 = reviewRepository.findById(reviewID);
        if (review1.isPresent()) {
            Review review2 = review1.get();

            review2.setReviewId(reviewRequest.getReviewId());
            review2.setProductId(reviewRequest.getProductId());
            review2.setSubject(reviewRequest.getSubject());
            review2.setAuthor(reviewRequest.getAuthor());
            review2.setContent(reviewRequest.getContent());
            reviewRepository.save(review2);
        }

    }
}
