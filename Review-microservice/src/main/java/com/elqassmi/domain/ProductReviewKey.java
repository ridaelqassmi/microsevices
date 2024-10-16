package com.elqassmi.domain;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor @NoArgsConstructor @Data
public class ProductReviewKey implements Serializable {

    private long productId;
    private long reviewId;


    // Override equals and hashCode for JPA
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductReviewKey that = (ProductReviewKey) o;
        return productId == that.productId && reviewId == that.reviewId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, reviewId);
    }
}
