package com.elqassmi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewResponse {
    private long reviewId;
    private long productId;
    private String author;
    private String Subject;
    private String Content;
}
