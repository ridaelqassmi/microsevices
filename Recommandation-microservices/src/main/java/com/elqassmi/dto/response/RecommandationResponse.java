package com.elqassmi.dto.response;

import com.elqassmi.domain.ProductRecommendationKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecommandationResponse {
    private ProductRecommendationKey productRecommendationKey;
    private String author;
    private String role;
    private String content;
}
