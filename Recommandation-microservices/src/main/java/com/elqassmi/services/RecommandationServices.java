package com.elqassmi.services;

import com.elqassmi.domain.ProductRecommendationKey;
import com.elqassmi.dto.request.RecommandationRequest;
import com.elqassmi.dto.response.RecommandationResponse;


import java.util.List;

public interface RecommandationServices {
    ProductRecommendationKey addRecommendation(RecommandationRequest recommandationRequest);

    public void updateLocation(long recommendationId, long productId, RecommandationRequest recommandationRequest) ;

        void deleteRecommendation(long recommendationId, long productId);

    List<RecommandationResponse> getAllRecommandation();

    RecommandationResponse getRecommendationById(long recommendationId, long productId);
}
