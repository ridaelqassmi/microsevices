package com.elqassmi.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Recommandation {
    @EmbeddedId
    //private ProductRecommendationKey productRecommendationKey;
    private long productId;
    private long recommendationId;

    private String author;
    private String role;
    private String content;
}
