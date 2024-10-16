package com.elqassmi.dto.response;

import com.elqassmi.domain.ProductReviewKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewResponse {
    private ProductReviewKey id;
    private String author;
    private String Subject;
    private String Content;
}
