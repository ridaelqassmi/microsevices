package com.elqassmi.services;

import com.elqassmi.dao.RecommandationRepository;
import com.elqassmi.domain.ProductRecommendationKey;
import com.elqassmi.domain.Recommandation;
import com.elqassmi.dto.request.RecommandationRequest;
import com.elqassmi.dto.response.RecommandationResponse;
import com.elqassmi.exception.RecommndationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecommendationServicesImp  implements RecommandationServices{
    @Autowired
    RecommandationRepository recommandationRepository;

    @Override
    public ProductRecommendationKey addRecommendation(RecommandationRequest recommandationRequest) {
        Recommandation recommandation = new Recommandation();
        recommandation.setAuthor(recommandationRequest.getAuthor());
        recommandation.setRole(recommandationRequest.getRole());
        recommandation.setContent(recommandationRequest.getContent());
        recommandation.setProductRecommendationKey(recommandationRequest.getProductRecommendationKey());
        recommandationRepository.save(recommandation);
        return recommandation.getProductRecommendationKey();
    }

    @Override
    public void updateLocation(long recommendationId, long productId,@RequestBody RecommandationRequest recommandationRequest) {
        ProductRecommendationKey productRecommendationKey = new ProductRecommendationKey(recommendationId,productId);

        Optional<Recommandation> recommandation1 = recommandationRepository.findById(productRecommendationKey);
        if (recommandation1.isPresent()) {
            Recommandation recommandation2 = recommandation1.get();

            recommandation2.setAuthor(recommandationRequest.getAuthor());
            recommandation2.setRole(recommandationRequest.getRole());
            recommandation2.setContent(recommandationRequest.getContent());
            recommandationRepository.save(recommandation2);

        }

    }

    @Override
    public void deleteRecommendation(long recommendationId, long productId) {
        ProductRecommendationKey productRecommendationKey = new ProductRecommendationKey(recommendationId,productId);
        Optional<Recommandation> recommandation1 = recommandationRepository.findById(productRecommendationKey);
        recommandation1.ifPresent(recommandation -> recommandationRepository.delete(recommandation));
    }

    @Override
    public List<RecommandationResponse> getAllRecommandation() {
        List<Recommandation> Recommendation = recommandationRepository.findAll();
        List<RecommandationResponse> recommendations = new ArrayList<>();
        for(Recommandation rec : Recommendation) {
            RecommandationResponse recommandationResponse = new RecommandationResponse();
            recommandationResponse.setAuthor(rec.getAuthor());
            recommandationResponse.setRole(rec.getRole());
            recommandationResponse.setContent(rec.getContent());
            recommandationResponse.setProductRecommendationKey(rec.getProductRecommendationKey());
            recommendations.add(recommandationResponse);
        }
        return recommendations;
    }

    @Override
    public RecommandationResponse getRecommendationById(long recommendationId, long productId) {
        ProductRecommendationKey productRecommendationKey = new ProductRecommendationKey(recommendationId,productId);

        Optional<Recommandation> recommandation = recommandationRepository.findById(productRecommendationKey);
        RecommandationResponse recommendationResponse = new RecommandationResponse();
        if (recommandation.isPresent()) {
            Recommandation Rec = recommandation.get();
            recommendationResponse.setAuthor(Rec.getAuthor());
            recommendationResponse.setRole(Rec.getRole());
            recommendationResponse.setProductRecommendationKey(productRecommendationKey);
            recommendationResponse.setContent(Rec.getContent());

        }else {
            throw new RecommndationNotFoundException("Recommendation with id = "+ productRecommendationKey+ " does not exist");
        }


        return recommendationResponse;
    }
}
