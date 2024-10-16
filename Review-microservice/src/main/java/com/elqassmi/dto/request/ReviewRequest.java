package com.elqassmi.dto.request;

import com.elqassmi.domain.ProductReviewKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewRequest {
    private ProductReviewKey id;

    private String author;
    private String Subject;
    private String Content;
}
