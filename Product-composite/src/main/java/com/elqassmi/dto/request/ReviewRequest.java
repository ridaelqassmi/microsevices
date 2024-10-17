package com.elqassmi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewRequest {
    private long reviewId;
    private long productId;
    private String author;
    private String Subject;
    private String Content;
}
