package com.elqassmi.services;

import com.elqassmi.dto.request.RecommandationRequest;
import com.elqassmi.dto.response.RecommandationResponse;


import java.util.List;

public interface RecommandationServices {
    public List<RecommandationResponse> getRecommendationByProductID(long id);
    long addRecommendation(RecommandationRequest recommandationRequest);

    public void updateLocation(long recommendationId, RecommandationRequest recommandationRequest) ;

        void deleteRecommendation(long recommendationId);

    List<RecommandationResponse> getAllRecommandation();

    RecommandationResponse getRecommendationById(long recommendationId);

}
