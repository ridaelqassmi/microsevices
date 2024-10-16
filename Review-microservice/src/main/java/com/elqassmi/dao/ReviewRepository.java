package com.elqassmi.dao;

import com.elqassmi.domain.ProductReviewKey;
import com.elqassmi.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, ProductReviewKey> {
}
