package com.elqassmi.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
    @EmbeddedId
    private ProductReviewKey id;
    private String author;
    private String subject;
    private String content;
}
