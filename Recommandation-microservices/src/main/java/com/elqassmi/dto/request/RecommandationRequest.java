package com.elqassmi.dto.request;

import com.elqassmi.domain.ProductRecommendationKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecommandationRequest {
    private ProductRecommendationKey productRecommendationKey;
    private String author;
    private String role;
    private String content;
}
